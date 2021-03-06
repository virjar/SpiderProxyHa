package com.virjar.spider.proxy.ha.admin.netty;


import com.google.common.base.Charsets;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public class DefaultHtmlHttpResponse extends DefaultFullHttpResponse {


    public DefaultHtmlHttpResponse(String content) {
        super(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST, Unpooled.wrappedBuffer(content.getBytes(Charsets.UTF_8)));

        //contentByteData = content.getBytes(Charsets.UTF_8);
        headers().set("Content-Type", "text/html;charset=utf8;");
        //  headers().set(HeaderNameValue.CONTENT_LENGTH, contentByteData.length);
    }

    private static final String badRequestContent = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>BadRequest</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>\n" +
            "    the SpiderProxyHa http server can not recognize you request,please contact you website admin\n" +
            "</h1>\n" +
            "<h2>\n" +
            "    SpiderProxyHa 服务器不识别你的请求，请联系管理员或者SpiderProxyHa作者\n" +
            "</h2>\n" +
            "</body>\n" +
            "</html>";

    private static final String notFoundContent = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Not Found</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>\n" +
            "    no handler found\n" +
            "</h1>\n" +
            "</body>\n" +
            "</html>";

    public static DefaultHtmlHttpResponse badRequest() {
        return new DefaultHtmlHttpResponse(badRequestContent);
    }


    public static DefaultHtmlHttpResponse notFound() {
        return new DefaultHtmlHttpResponse(notFoundContent);
    }


}

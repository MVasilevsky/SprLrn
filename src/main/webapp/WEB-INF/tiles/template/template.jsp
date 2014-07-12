<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> <tiles:insertAttribute name="title"/></title>
    </head>
    <body>
        <div class="page">
            <tiles:insertAttribute name="header" />
            <div class="content">
                <tiles:insertAttribute name="menu" />
                <tiles:insertAttribute name="body" />
            </div>
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>
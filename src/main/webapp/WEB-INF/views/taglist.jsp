<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="title">
        Add user
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="body">
            <h1>Tags list</h1>
            <a href="/tag/add">Add tag</a>
            <table>
                <tr>
                    <th>Title</th>
                    <th>Creator</th>
                    <th>Creation date</th>
                </tr>
                <c:forEach var="tag" items="${tags}">
                    <tr>
                        <td>${tag.title}</td>
                        <td>${tag.creator.login}</td>
                        <td><fmt:formatDate type="date" value="${tag.creationDate}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="title">
        Add user
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="body">
            <h1>Users list</h1>
            <a href="/quote/add">Add quote</a>
            <table>
                <tr>
                    <th>Picture</th>
                    <th>Tags</th>
                    <th>Uploading date</th>
                </tr>
                <c:forEach var="quote" items="${quotes}">
                    <tr>
                        <td>${quote.picture}</td>
                        <td><c:forEach var="tag" items="${quote.tags}">${tag.title}</c:forEach></td>
                        <td><fmt:formatDate type="date" value="${quote.uploadingDate}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
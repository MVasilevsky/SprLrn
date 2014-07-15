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
            <a href="/user/add">Add user</a>
            <table>
                <tr>
                    <th>Login</th>
                    <th>Role</th>
                    <th>Registration date</th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.login}</td>
                        <td>${user.role.code}</td>
                        <td><fmt:formatDate type="date" value="${user.registrationDate}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="title">
        Add user
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="body">
            <h1>Add user</h1>
            <form action="/user/add" method="post">
                <input name="login" type="text"/>
                <select name="role">
                    <option value="0">First</option>
                    <option value="1">Second</option>
                    <option value="2">Third</option>
                </select>
                <button type="submit">Submit</button>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
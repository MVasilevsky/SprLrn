<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="title">
        Add tag
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="body">
            <h1>Add tag</h1>
            <form action="/tag/add" method="post">
                <input name="title" type="text"/>
                <button type="submit">Submit</button>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
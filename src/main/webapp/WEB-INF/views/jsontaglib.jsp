<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<json:object>
    <json:array name="students" var="student" items="${students}">
        <json:object>
            <json:property name="id" value="${student.id}"/>
            <json:property name="name" value="${student.name}"/>
            <json:property name="studentId" value="${student.studentId}"/>
            <json:property name="createAt" value="${student.createAt}"/>
            <json:property name="updateAt" value="${student.updateAt}"/>
        </json:object>
    </json:array>
</json:object>


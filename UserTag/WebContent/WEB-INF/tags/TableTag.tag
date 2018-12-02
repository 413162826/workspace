<%@tag description="My Table" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"%>
<%@attribute name="author" %>
<%@attribute name="price_info" %>
<table border="1">
    <tr><td align="center">
               <h2>${title}</h2>
            </td></tr>
    <tr> <td><em>作者：</em>
               <strong>${author}</strong>
            </td></tr>
    <tr><td><em>价格：</em>
         <strong>${price_info}</strong>
           </td></tr>
</table>

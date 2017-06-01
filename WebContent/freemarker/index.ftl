<#assign seq = ["foo", "bar", "baz"]>
<#assign  x = 3>
<#assign t=JspTaglibs["/WEB-INF/tags"] />

<t:genericpage>

  <form name="user" action="hello" method="post">
  	Firstname: <input type="text" name="firstname" />	<br/>
  	Lastname: <input type="text" name="lastname" />		<br/>
  	<input type="submit" value="Save" />
  </form>

  <table class="datatable">
  	<tr>
  		<th>Firstname</th>  <th>Lastname</th>
  	</tr>
    <#list users as user>
  	<tr>
  		<td>${user.firstName}</td> <td>${user.lastName}</td>
  	</tr>
    </#list>
  </table>
</t:genericpage>
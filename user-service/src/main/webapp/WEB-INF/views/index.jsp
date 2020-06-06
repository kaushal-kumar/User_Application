<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;

.errorLabel {
    color: red;
}

}
</style>
<script>
function setURL(form) {
    var action_src = "";
    if (form.urlVal.value === "") {
        action_src = "/";
    } else {
        action_src="/user/"+form.urlVal.value+"/search";
    }
    var searchForm = document.getElementById("search_form")
    searchForm.action = action_src;
 }
</script>
<h1>User Application</h1>
<div>
        <Container fluid>
          <div className="float-right">
              <form id="search_form" onsubmit="setURL(this)">
                  <input type="text" id="urlVal" placeholder="Search name or phone"/>
                  <input type="submit" value="Search" />
              </form>
          </div>
          <br/>
          <c:if test="${foundUser eq 'false'}">
          <h3 style="color: red;">No data found</h3>
          </c:if>
          <table class="sortable">
            <thead>
            <tr>
              <th>Name</th>
              <th>Email</th>
              <th>Address</th>
              <th>Phone</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var = "user">
            <tr>
               <td>${user.name}</td>
               <td>${user.email}</td>
               <td>${user.address}</td>
               <td>${user.phn}</td>
            </tr>
            </c:forEach>
            </tbody>
          </table>
          <br/>
          <div>
            <button type="submit"><a href="/user/sort">Sort By Name</a></button>
            <button type="submit"><a href="/add/user">Add User</a></button>
           </div>
        </Container>
      </div>
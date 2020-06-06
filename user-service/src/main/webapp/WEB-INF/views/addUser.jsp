<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<style>
* {box-sizing: border-box}

/* Add padding to containers */
.container {
  padding: 16px;
}

form {
    width: 50%;
    margin: auto;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit/register button */
.addbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.addbtn:hover {
  opacity:1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
<h1>User Application</h1>
<div width="50%">
          <form method="post" action="/user/create">
            <div class="container">
              <h3 style="text-align: center;">Add New User</h3>
              <label for="name"><b>Name</b></label>
              <input type="text" placeholder="Enter Name" name="name" id="name" required>
              <label for="email"><b>Email</b></label>
              <input type="text" placeholder="Enter Email" name="email" id="email" required>
              <label for="phn"><b>Phone</b></label>
              <input type="text" placeholder="Enter Phone" name="phn" id="phn" required>
              <label for="address"><b>Address</b></label>
              <input type="text" placeholder="Enter Address" name="address" id="address" required>
              <button type="submit" class="addbtn">Add User</button>
            </div>
          </form>
</div>
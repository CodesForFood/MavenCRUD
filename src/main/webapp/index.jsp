<html>
	<body>
		<h1>Welcome to the Author CRUD website assignment using maven</h1>
		
		<div>
			
			<form action="/webApp/add" method="POST">
				<h4>Add Author</h4>
				<label for="aNameAdd">Author Name:</label>
				<input id="aNameAdd" type="text" name="authName" required="required"/>	
				<br>
				<input type="submit" value="Add" />		 
			</form>		
		</div>
		
		
		<div>
			<h4>Update an author</h4>
			<form action="/webApp/update" method="POST">
				<label for="aId">Author Id:</label>
				<input id="aId" type="text" name="authId" required="required"/>	
				<br>
				<label for="aNameUpdate">Author Name:</label>
				<input id="aNameUpdate" type="text" name="authName" required="required"/>	
				<br>
				<input type="submit" value="Update"/>			 
			</form>
		</div>
		
		<div>
			<h4>Delete an Author</h4>
			<form action="/webApp/delete" method="POST">
				<label for="aIdDelete">Author Id:</label>
				<input id="aIdDelete" type="text" name="authId" required="required"/>
				<input type="submit" value="Delete" />
			</form>
		</div>
		
		
		<form action="/webApp/viewAll" method="GET">
    		<input type="submit" value="View All" />
		</form>					
		
	</body>
</html>

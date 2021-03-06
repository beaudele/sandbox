<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">
		<span class="lead">List of Users </span>
	</div>
	<div class="tablecontainer">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID.</th>
					<th>Name</th>
					<th>Address</th>
					<th>Email</th>
					<th width="20%"></th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="u in ctrl.users">
					<td><span ng-bind="u.id"></span></td>
					<td><span ng-bind="u.username"></span></td>
					<td><span ng-bind="u.address"></span></td>
					<td><span ng-bind="u.email"></span></td>
					<td><a ui-sref="user_edit({id: u.id})">
							<button type="button" ng-click="ctrl.edit(u.id)"
								class="btn btn-success custom-width">Edit</button>
					</a>
						<button type="button" ng-click="ctrl.remove(u.id)"
							class="btn btn-danger custom-width">Remove</button></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

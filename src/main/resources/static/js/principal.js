let user = getPrincipal();

let usercode = 0;

usercode = getUserCode();

function getUserCode (){
	if(user != null){
		return user.user_code;
	}
}

function getPrincipal() {
	let user = null;
	
	$.ajax({
		async: false,
		type: "get",
		url: "/api/v1/principal",
		dataType: "json",
		success: (response) => {
			user = response.data;
		},
		error: (error) => {
			console.log(error);
		}
	});
	
	return user;	
}

function getUser() {
	return user;
}
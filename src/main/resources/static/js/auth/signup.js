const inputs = document.querySelectorAll(".form-control");
const signUpBtn = document.querySelector(".btn");

signUpBtn.onclick = ()=> {
	
	  let signupData = {
	      userid: inputs[0].value,
	      username: inputs[1].value,
	      useremail: inputs[2].value,
	      password: inputs[3].value
      }
      
      console.log(signupData);
	
	$.ajax({
      async: false,
      type: "post",
      url: "/api/v1/auth/signup",
      contentType: "application/json",
      data: JSON.stringify(signupData),
      dataType: "json",
      success: (response) => {
         if(response.data){
         alert("회원가입 완료.");
         location.replace("/auth/signin");            
         }
      },
      error:(error) => {
         if(error.status == 400){
            alert(JSON.stringify(error.responseJSON.data))
         }
         console.log("요청실패");
         console.log(error);         
      }
   });
}


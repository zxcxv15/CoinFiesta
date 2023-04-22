const inputs = document.querySelectorAll(".form-control");
const signUpBtn = document.querySelector(".btn");

function validatePassword(password) {
  const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/; // 비밀번호 패턴
  return passwordRegex.test(String(password));
}

function validateEmail(email) {
  const emailRegex = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/; // 이메일 주소 패턴
  return emailRegex.test(String(email).toLowerCase());
}

//회원가입 아이디 중복체크
let checkUseridFlag = false;

//회원가입 이메일 중복체크
let checkUseremailFlag = false;

inputs[0].onblur = () => {
	
 $.ajax({
      async: false,
      type: "get",
      url: "/api/v1/auth/signup/validation/userid",
      data: {userid : inputs[0].value},
      dataType: "json",
      success: (response) => {
         checkUseridFlag = response.data;
         
         if(checkUseridFlag){
            alert("사용 가능한 아이디 입니다.");
         }else{
            alert("이미 사용중인 아이디 입니다.");
         }
      },
      error: (error) => {
         if(error.status == 400){
            alert(JSON.stringify(error.responseJSON.data));
         }else{
            console.log("요청실패");
            console.log(error);                     
         }
      }
   });
}

inputs[3].onblur = () => {
	$.ajax({
		async: false,
		type: "get",
		url: "/api/v1/auth/signup/validation/useremail",
		data: {useremail: inputs[3].value},
		dataType: "json",
		success: (respones) => {
			checkUseremailFlag = respones.data;
			
			if(checkUseremailFlag){
				alert("사용 가능한 이메일 입니다.");
			}else{
				alert("이미 사용중인 이메일 입니다.");
			}
		},
		 error: (error) => {
         if(error.status == 400){
            alert(JSON.stringify(error.responseJSON.data));
         }else{
            console.log("요청실패");
            console.log(error);                     
         }
      }
	});
}

signUpBtn.onclick = ()=> {
   // 입력 필드 검사
   if(!validateEmail(inputs[3].value)) {
      alert("올바른 이메일 주소를 입력하세요.");
      return;
   }
   if(!validatePassword(inputs[1].value)) {
      alert("비밀번호는 최소 8자 이상이며, 대문자, 소문자, 숫자, 특수문자를 포함해야 합니다.");
      return;
   }
   
   // 회원가입 데이터 생성
   let signupData = {
      userid: inputs[0].value,
      password: inputs[1].value,
      username: inputs[2].value,
      useremail: inputs[3].value
   }
   
   console.log(signupData);

   // AJAX 요청
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


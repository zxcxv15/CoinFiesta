const btnPrimary = document.querySelector(".btn-primary");
const title = document.querySelector("#title");
const content = document.querySelector("#content");



btnPrimary.onclick = () => {
	 
    let formData = new FormData(document.querySelector("form"));
    
    formData.append("usercode", getUser().user_code);
    
    formData.forEach((v, k) => {
		console.log("key: " + k);
		console.log("value: " + v);
	});
	alert("게시글 작성하시겠습니까.");
	 $.ajax({
      async: false,
      type: "post",
      url: "/api/v1/board/write",
      enctype: "multipart/form-data",
	  contentType: false,
	  processData: false,
	  data: formData,
	  dataType: "json",
      success: (response) => {
         if(response.data){
         alert("게시판 작성 완료하였습니다.");  
         location.replace("/board/list");
       
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

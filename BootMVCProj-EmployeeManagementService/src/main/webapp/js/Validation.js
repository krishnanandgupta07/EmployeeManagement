
function doValidation(frm){
		// empty old form validation message
		 document.getElementById("enameErr").innerHTML="";
		 document.getElementById("jobErr").innerHTML="";
		 document.getElementById("salErr").innerHTML="";
		 document.getElementById("deptnoErr").innerHTML="";
		 console.log("running js")
		 //read form comp "
		 let name=frm.ename.value;
		 let desg=frm.job.value;
		 let salary=frm.sal.value;
		 let deptno=frm.deptno.value;
		 
		 let isValid=true;
		  //write  client side form validation 
		  if(name==""){ //required rule
			  document.getElementById("enameErr").innerHTML="Employee name is mandatory(cs)	";
			  isValid=false;
		  }
		  else if(name.length<5 || name.length>=15){  //length rule
			  document.getElementById("enameErr").innerHTML="Employee name must contain >=5 char and <=15 (cs)";
			  isValid=false;
		  }
		  
		  		  if(desg==""){ //required rule
			  document.getElementById("jobErr").innerHTML="Employee desgination is mandatory	(cs)";
			  isValid=false;
		  }
		  else if(desg.length<5 || desg.length>=10){  //length rule
			  document.getElementById("jobErr").innerHTML="Employee Job must contain >=5 char and <=10 (cs)";
			  isValid=false;
		  }
		  
		  		  if(salary==""){ //required rule
			  document.getElementById("salErr").innerHTML="Employee salary is mandatory	 (cs)";
			  isValid=false;
		  }
		  else if(isNaN(salary)){  //length rule
			  document.getElementById("salErr").innerHTML="Employee salary must be numeric (cs)";
			  isValid=false;
		  }
		  
		  	  else if(salary<1000 || salary>200000){  //length rule
			  document.getElementById("salErr").innerHTML="Employee salary must be in range <= 1000 to >=200000  (cs)";
			  isValid=false;
		  }
		  
		  		  if(deptno==""){ //required rule
			  document.getElementById("deptnoErr").innerHTML="Employee deptno is mandatory	(cs)";
			  isValid=false;
		  }
		  
		  	  else if(isNaN(deptno)){  //length rule
			  document.getElementById("deptnoErr").innerHTML="Employee deptno must be numeric (cs)";
			  isValid=false;
		  }
		  
		  	  else if(deptno<10 || deptno>50){  //length rule
			  document.getElementById("deptnoErr").innerHTML="Employee deptno must be in range <= 10 to >=50 (cs)";
			  isValid=false;
		  
		  }
		  
		  // change the hidden box value "enabled " indicating that client side form validation is done
		  frm.csvStatus.value="enabled";
		  return isValid;
		 	 
}
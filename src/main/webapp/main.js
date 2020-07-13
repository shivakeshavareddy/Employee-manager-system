/**
 * 
 */

		function handleLoad() {
			document.getElementById("submit").disabled = true;
			const inputs = document.getElementsByTagName("input");

			for (let i = 0; i < inputs.length; i++) {
				const input = inputs[i];
				if (input.type === 'text') {
					input.value = ''
					input.disabled = true
				} else if (input.type === 'checkbox') {
					input.checked = false
				}
			}


		}
		function handleChange(e) {
			document.getElementById("text" + e.target.value).disabled = !e.target.checked

			if (!e.target.checked) {
				document.getElementById("text" + e.target.value).value = ""
			}
			handleSubmitEnable()

		}

		function handleInput(e) {
			if (e.charCode === 46) {
				return !e.target.value.includes(".")
			}
			else if (e.charCode >= 48 && e.charCode <= 57) {
				return true
			} else {
				return false
			}
		}

		function handleSubmitEnable() {
			const dproj = document.getElementsByName("dproject");
			let proj = 0;
			for (let i = 0; i < dproj.length; i++) {
				if (dproj[i].checked) {
					proj++;
				}
			}

			const dHours = document.getElementsByClassName("departmentHours");
			let totalHours = 0;
			for (let j = 0; j < dHours.length; j++) {
				console.log(dHours[j].value)
				if (dHours[j].value && dHours[j].value.length > 0) {
					totalHours = totalHours + parseFloat(dHours[j].value)
				}
			}

			document.getElementById("submit").disabled = !((proj === 1 || proj === 2) && (totalHours > 0 && totalHours <= 40))
		}
		
		function dependentsvalue(){
			let rd1= document.getElementById("yes");
			let rd2=document.getElementById("no");
			if(rd1.checked ===true){
				document.getElementById("depenedentnum").style.display="block";
			}
			else{
				document.getElementById("depenedentnum").style.display="none";
			}

		}
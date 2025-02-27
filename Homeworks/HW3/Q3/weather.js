function toCelsius(){

	// grabs the input from the user
	let input =  document.getElementById("temperature").value;

	// converts the temperature to C
	let celsius = (input - 32) * 5/9;

	//check if input was number
	if (isNaN(celsius)){
		warning = "<div class=myparagraph>This is not a number!</div>";
		let parent = document.getElementById("result-parent")
		parent.innerHTML = warning;
	}
	else {
		//restore parent
		let parent = document.getElementById("result-parent");
		parent.innerHTML = ` The Temperature in Celsius is <span id="result"></span>`;
		// show back to the user, on the <span> element
		document.getElementById("result").innerText = celsius;
	}
	// makes the div visible
	// element.style can be used to change CSS properties of an HTML document
	document.getElementById("result-parent").style.visibility = "visible";
}
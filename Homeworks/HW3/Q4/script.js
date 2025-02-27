emailButton = document.getElementById("email-btn");
emailInput = document.getElementById("email-input")

emailButton.addEventListener("click", sendMail);
console.log(emailInput)

function sendMail(){
    const email = 'alinare2@nd.edu';
    const subject = 'From Personal Website';
    const body = emailInput.value;
    const mailToUrl = `mailto:${email}?subject=${encodeURIComponent(subject)}&body=${encodeURIComponent(body)}`;
    window.location.href = mailToUrl;
}
// Get the user data from local storage
const user = JSON.parse(localStorage.getItem('loggedInUser'));

// Set the user account and login information
document.getElementById('user-account').textContent = user.account + '$';
document.getElementById('user-login').textContent = user.login;

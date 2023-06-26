const popup = document.querySelector(".popup");
const popupTrigger = document.querySelectorAll(".popup-trigger");
const body = document.querySelector("body");
const closeBtn = document.querySelector(".close-btn");
const popupImage = document.querySelector(".popup__image img");
const imageSrc = document.querySelectorAll(".card__image img");
//const popupTitle = document.querySelectorAll(".card__content h2");
//const popupContent = document.querySelectorAll(".card__content p");
let len = popupTrigger.length;

for (let i = 0; i < len; i++) {
	popupTrigger[i].addEventListener('click', (event) => {
		event.preventDefault();
		popup.classList.toggle('visible');
		body.classList.toggle('lock');
		popupImage.src = imageSrc[i].getAttribute('src');
		brake;
	});
}

closeBtn.addEventListener('click', (event) => {
	event.preventDefault();
	popup.classList.toggle('visible');
	body.classList.toggle('lock');
});
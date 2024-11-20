
        window.onload = function() {
            var splashScreen = document.querySelector('.splash');
            if (splashScreen) {
                splashScreen.style.opacity = 1;
                setTimeout(() => {
                    splashScreen.classList.add('hidden');
                }, 100); 
            }
        };
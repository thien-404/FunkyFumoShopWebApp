document.addEventListener("DOMContentLoaded", function() {
    const searchForm = document.querySelector('form[action="MainController"]');

    if (searchForm) {
        searchForm.addEventListener('submit', function(event) {
            const actionValue = event.target.querySelector('button[type="submit"][name="action"]').value;
            if (actionValue === 'SearchProduct') {
                sessionStorage.setItem('shouldScroll', 'true');
            }
        });
    }


    const shouldScroll = sessionStorage.getItem('shouldScroll') === 'true';

    if (shouldScroll) {
        const autoScrollSection = document.getElementById('auto-scroll');
        if (autoScrollSection) {
            autoScrollSection.scrollIntoView({ behavior: 'smooth' });
            sessionStorage.removeItem('shouldScroll'); 
        }
    }
});
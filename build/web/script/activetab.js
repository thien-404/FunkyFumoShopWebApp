        $(document).ready(function() {
            var activeTab = localStorage.getItem('activeTab') || '#users';
            $(activeTab).addClass('show active');
            $('a[href="' + activeTab + '"]').tab('show');

            $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
                var target = $(e.target).attr("href");
                localStorage.setItem('activeTab', target);
            });

            $('form').on('submit', function() {
                var activeTab = $('.nav-link.active').attr('href');
                $(this).append('<input type="hidden" name="activeTab" value="' + activeTab + '"/>');
            });
        });
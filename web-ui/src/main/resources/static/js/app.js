$(document).ready(function(){
    $('body').addClass('skin-blue sidebar-mini wysihtml5-supported');
    $('body').addClass(localStorage.getItem('sidebar-collapse'));
});
$('body').on('expanded.pushMenu collapsed.pushMenu', function(e) {
	var collape = localStorage.getItem('sidebar-collapse');
	if(collape==='sidebar-collapse')
		localStorage.setItem('sidebar-collapse', '');
	else
		localStorage.setItem('sidebar-collapse', 'sidebar-collapse');
});
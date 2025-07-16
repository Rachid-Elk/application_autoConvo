// static/js/filters.js

document.addEventListener("DOMContentLoaded", function () {
    $('.select2').select2({
        theme: 'bootstrap-5',
        width: '100%',
        placeholder: 'Sélectionner',
        allowClear: true
    });

    $('#multiple-select-clear-field').select2({
        theme: 'bootstrap-5',
        width: '100%',
        placeholder: 'Filtrer...',
        allowClear: true,
        closeOnSelect: false
    });

    $('#multiple-select-field').select2({
        theme: 'bootstrap-5',
        width: '100%',
        placeholder: 'Sélectionner...',
        closeOnSelect: false
    });
});

function resetFilters() {
    const form = document.querySelector('form');
    form.querySelectorAll('input, select').forEach(field => {
        if (field.type === 'text' || field.type === 'number') {
            field.value = '';
        } else if (field.tagName === 'SELECT') {
            field.selectedIndex = 0;
        }
    });
}

function resetAndRedirect() {
    window.location.href = '/candidats';
}

function resetFilters() {
    document.querySelectorAll('#cin, #nom, #prenom, #sexe').forEach(input => input.value = '');
    $('.select2').val(null).trigger('change');
}

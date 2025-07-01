let comuniData = {};

// Carica i dati dei comuni da JSON al caricamento della pagina
fetch('/assets/json/comuni.json')
    .then(response => response.json())
    .then(data => {
    comuniData = data;
    });

// Quando cambia la provincia
document.getElementById('provincia').addEventListener('change', function () {
    const codiceProvincia = this.value;
    const comuneSelect = document.getElementById('comune');
    comuneSelect.innerHTML = '<option value="">-- Seleziona un comune --</option>';

    if (comuniData[codiceProvincia]) {
    comuniData[codiceProvincia].forEach(comune => {
        const option = document.createElement('option');
        option.value = comune;
        option.textContent = comune;
        comuneSelect.appendChild(option);
        });
    }
});
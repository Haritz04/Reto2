window.onload = function buttonLoad() {
  console.log("Cargando...");

  document.getElementById("flightDiv").style.display = "none";
  document.getElementById("accommodationDiv").style.display = "none";
  document.getElementById("otherDiv").style.display = "none";
};

function showFlights() {
  if (document.getElementById("flightsBtn").checked) {
    console.log("Mostrando elemento...");
    document.getElementById("flightDiv").style.display = "block";
    document.getElementById("accommodationDiv").style.display = "none";
    document.getElementById("otherDiv").style.display = "none";
  }
}
function showAcommodation() {
  if (document.getElementById("accommodationBtn").checked) {
    document.getElementById("flightDiv").style.display = "none";
    document.getElementById("accommodationDiv").style.display = "block";
    document.getElementById("otherDiv").style.display = "none";
  }
}
function showOthers() {
  if (document.getElementById("otherBtn").checked) {
    document.getElementById("flightDiv").style.display = "none";
    document.getElementById("accommodationDiv").style.display = "none";
    document.getElementById("otherDiv").style.display = "block";
  }
}

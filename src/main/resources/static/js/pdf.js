window.onload = function () {
  document.getElementById("download").addEventListener("click", () => {
    const printDoc = this.document.getElementById("print_doc");
    console.log(printDoc);
    var opt = {
      margin: 0.3,
      filename: "myfile.pdf",
      image: { type: "jpeg", quality: 1 },
      html2canvas: { scale: 1 },
      jsPDF: { unit: "in", format: "a4", orientation: "portrait" },
    };
    html2pdf().set(opt).from(printDoc).save();
    //    htlml2pdf().from(printDoc).save();
  });
};

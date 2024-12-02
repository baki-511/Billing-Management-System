// const client_mob = clientBody.querySelector(".client-mob").innerHTML;
const saveBillBtn = document.getElementById("save-bill");
// const prodId = document.querySelector(".client-mob");

saveBillBtn.addEventListener("click", async () => {
  console.log("Click....");
  const clientBody = document.querySelector(".client-select-tbody");
  const client_mob = clientBody.querySelector(".client-mob").innerHTML;

  //   const response = await fetch(
  //     `http://localhost:8084/rest/client/mob/${client_mob}`
  //   );
  //   const getClient = await response.json();
  //   console.log(getClient);

  const tbody = document.querySelector(".select-tbody");
  //   console.log(tbody);

  const productRows = tbody.querySelectorAll("tr");
  const products = [];

  productRows.forEach((row) => {
    const productId = row.querySelector("td:nth-child(2)").textContent; // 2nd <td> contains Product ID
    const quantity = parseInt(row.querySelector(".quantity").value, 10);

    products.push({
      productId: productId,
      qty: quantity,
    });
  });

  const BillData = {
    clientMob: client_mob,
    billProducts: products,
  };

  console.log(BillData);
  const response = await fetch(`http://localhost:8084/rest/bill/save`, {
    method: "POST",
    headers: {
      "Content-type": "application/json",
    },
    body: JSON.stringify(BillData),
  });
  const result = await response.json();
  console.log(result);
});

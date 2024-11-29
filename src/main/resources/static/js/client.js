let allProducts = [];
let selectedProduct = [];

const GET_PRODUCT_BY_ID = `http://localhost:8080/rest/product`;

export const fetchProducts = async () => {
  const response = await fetch("http://localhost:8084/rest/client/all");
  return response.json();
};

export const renderProducts = (clients) => {
  // const tBody = document.querySelector("tbody");
  const tBody = document.getElementById("client-tbody");
  console.log(tBody);
  tBody.innerHTML = "";
  try {
    clients.forEach((client, idx) => {
      const tr = document.createElement("tr");
      tr.classList.add("py-3");

      tr.innerHTML = `
      <td class="text-nowrap px-2">${idx + 1}</td>
      <td class="text-nowrap px-2">${client.clientName}</td>
      <td class="text-nowrap px-2 client-mob">${client.mobile}</td>
      <td class="text-nowrap px-2">${client.email}</td>
    `;
      tBody.appendChild(tr);
    });
  } catch (error) {
    console.log(error);
  }
};

export const addProduct = (prod) => {
  // if (!selectedProduct.some((p) => p.mobile === prod.mobile)) {
  //   selectedProduct.push(prod);
  //   renderedSelectedList(selectedProduct);
  // }
  renderedSelectedList(prod);
};

const renderedSelectedList = (client) => {
  const tbody = document.querySelector(".client-select-tbody");

  tbody.innerHTML = "";

  const tr = document.createElement("tr");
  tr.classList.add("py-3");

  // Use the previously saved quantity if available, otherwise default to 1

  tr.innerHTML = `
        <tr>
            <td>${client.clientName}</td>
            <td class="client-mob">${client.mobile}</td>
            <td>${client.email}</td>
            <td>
            <button class="remove-btn btn btn-outline btn-danger" >
             <i class="fa-solid fa-xmark"></i>
            </button>
            </td>
          </tr>
  `;

  const removeBtn = tr.querySelector(".remove-btn");

  removeItem(removeBtn);
  tbody.appendChild(tr);

};

const removeItem = (removeBtn) => {
  removeBtn.addEventListener("click", (e) => {
    const removeIcon = e.target.querySelector("i") || e.target; // This ensures we get the <i> element regardless of where the click occurred inside the button

    // Get the value of data-index from the <i> element
    const productId = removeIcon.getAttribute("data-index");
    let idx = selectedProduct.findIndex((p) => p.productId == productId);
    selectedProduct.splice(idx, 1);
    // deleteRenderedProduct(selectedProduct);
    renderedSelectedList(selectedProduct);
  });
};

export const getClient = async (mob) => {
  try {
    const response = await fetch(
      `http://localhost:8084/rest/client/mob/${mob}`
    );

    // Check if the response is successful (status code 200-299)
    if (!response.ok) {
      throw new Error(`Error fetching product: ${response.statusText}`);
    }

    // Parse the JSON response
    const client = await response.json();

    return client; // Return the product data
  } catch (error) {
    // Handle any errors that occurred during the fetch
    console.error("Error:", error);
    return null; // Optionally, you can return a default value or throw an error
  }
};

// console.log(getProduct(12).then(prod=>console.log(prod)));

// document.addEventListener("DOMContentLoaded", init);

//===================================== Search Client Section ========================================

const searchBar = document.getElementById("client-inp");
const prodTable = document.querySelector(".client-table");

searchBar.addEventListener("input", async (e) => {
  const words = e.target.value;
  if (words.length) {
    prodTable.style.display = "block";
    const allProducts = await fetchProducts();
    const searchTerm = words.toLowerCase();
    const filteredProducts = allProducts.filter(
      (product) =>
        String(product.mobile).includes(searchTerm) ||
        product.clientName.toLowerCase().includes(searchTerm) ||
        product.email.toLowerCase().includes(searchTerm)
    );
    renderProducts(filteredProducts);
    addToList(filteredProducts);
  } else {
    prodTable.style.display = "none";
  }
});

const addToList = (products) => {
  const allTBody = document.querySelectorAll(".client-tbody tr");
  // console.log(allTBody);
  allTBody.forEach((r) => {
    r.addEventListener("click", (e) => {
      // Select the specific cell with the 'client-mob' class
      const clientMobCell = r.querySelector(".client-mob").innerHTML;
      getClient(clientMobCell).then((prod) => addProduct(prod));

    });
  });
};

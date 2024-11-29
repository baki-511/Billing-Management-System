let allProducts = [];
let selectedProduct = [];

const GET_PRODUCT_BY_ID = `http://localhost:8080/rest/product`;

export const fetchProducts = async () => {
  const response = await fetch("http://localhost:8084/rest/product/all");
  return response.json();
};

export const renderProducts = (products) => {
  // const tBody = document.querySelector("tbody");
  const tBody = document.getElementById("my-tbody")
  console.log(tBody)
  tBody.innerHTML = "";
  try {
    products.forEach((product, idx) => {
      const tr = document.createElement("tr");
      tr.classList.add("py-3");

      tr.innerHTML = `
      <td class="text-nowrap px-2">${product.productId}</td>
      <td class="text-nowrap px-2">${product.prodName}</td>
      <td class="text-nowrap px-2">$${product.price.toFixed(
        2
      )}</td>
      

    `;
      tBody.appendChild(tr);
    });
  } catch (error) {
    console.log(error);
  }
};

const init = async () => {
  allProducts = await fetchProducts();
  renderProducts(allProducts);

  const allTBody = document.querySelectorAll(".my-tbody tr");
  allTBody.forEach((r) => {
    r.addEventListener("click", (e) => {
      const firstTd = r.querySelector("td").innerHTML;
      getProduct(firstTd).then((prod) => addProduct(prod));
    });
  });
};

export const addProduct = (prod) => {
  if (!selectedProduct.some((p) => p.productId === prod.productId)) {
    selectedProduct.push(prod);
    renderedSelectedList(selectedProduct);
  }
};

const renderedSelectedList = (products) => {
  const tbody = document.querySelector(".select-tbody");
  const currentQuantities = {};
  tbody.querySelectorAll("tr").forEach((row) => {
    const productId = row
      .querySelector(".remove-btn i")
      .getAttribute("data-index");
    const quantity = parseInt(row.querySelector(".quantity").value, 10) || 1;
    currentQuantities[productId] = quantity; // Store the current quantity
  });
  tbody.innerHTML = "";

  try {
    products.forEach((product, idx) => {
      const tr = document.createElement("tr");
      tr.classList.add("py-3");

      // Use the previously saved quantity if available, otherwise default to 1
      const quantity = currentQuantities[product.productId] || 1;

      tr.innerHTML = `
        <tr>
            <td>${idx + 1}</td>
            <td>${product.productId}</td>
            <td>${product.prodName}</td>
            <td>${product.price}</td>
            <td><input type="number" class="p-2 quantity" min="1" max="5" value="${quantity}" style="width: 70px;"></td>
             <td class="subtotal">${product.price * quantity}</td>
            <td>
            <button class="remove-btn btn btn-outline btn-danger" >
            <i class="fa-solid fa-xmark" data-index="${
              product.productId
            }"></i></button>
            </td>
          </tr>
  `;

      const quantityInput = tr.querySelector(".quantity");
      const totalCell = tr.querySelector(".subtotal");

      quantityInput.addEventListener("input", () => {
        const newQuantity = parseInt(quantityInput.value, 10) || 1;
        totalCell.textContent = product.price * newQuantity;
      });

      const removeBtn = tr.querySelector(".remove-btn");

      removeItem(removeBtn);
      tbody.appendChild(tr);
    });
  } catch (error) {}
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

export const getProduct = async (id) => {
  try {
    const response = await fetch(`http://localhost:8084/rest/product/${id}`);

    // Check if the response is successful (status code 200-299)
    if (!response.ok) {
      throw new Error(`Error fetching product: ${response.statusText}`);
    }

    // Parse the JSON response
    const product = await response.json();

    return product; // Return the product data
  } catch (error) {
    // Handle any errors that occurred during the fetch
    console.error("Error:", error);
    return null; // Optionally, you can return a default value or throw an error
  }
};

// console.log(getProduct(12).then(prod=>console.log(prod)));

// document.addEventListener("DOMContentLoaded", init);



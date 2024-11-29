import {
  fetchProducts,
  renderProducts,
  addProduct,
  getProduct,
} from "/js/bill.js";

const searchBar = document.getElementById("prodInp");
const prodTable = document.querySelector(".prod-table");


searchBar.addEventListener("input", async (e) => {
  const words = e.target.value;
  if (words.length) {
    prodTable.style.display = "block";
    const allProducts = await fetchProducts();
    const searchTerm = words.toLowerCase();
    const filteredProducts = allProducts.filter(
      (product) =>
        String(product.productId).includes(searchTerm) ||
        product.prodName.toLowerCase().includes(searchTerm) ||
        product.description.toLowerCase().includes(searchTerm)
    );
    renderProducts(filteredProducts);
    addToList(filteredProducts);
  } else {
    prodTable.style.display = "none";
  }
});

const addToList = (products) => {
  const allTBody = document.querySelectorAll(".my-tbody tr");
  console.log("tBody : "+allTBody);
  
  allTBody.forEach((r) => {
    r.addEventListener("click", () => {
      const id = r.querySelector("td");
      console.log(id);
      
      const firstTd = r.querySelector("td").innerHTML;
      getProduct(firstTd).then((prod) => addProduct(prod));
    });
  });
};

var citis = document.getElementById("cityBranches");
var district = document.getElementById("districtBranches");
var ward = document.getElementById("wardBranches");
var Parameter = {
  url: "https://provinces.open-api.vn/api/?depth=3", //Đường dẫn đến file chứa dữ liệu hoặc api do backend cung cấp
  method: "GET", //do backend cung cấp
  responseType: "application/json", //kiểu Dữ liệu trả về do backend cung cấp
};
//gọi ajax = axios => nó trả về cho chúng ta là một promise
var promise = axios(Parameter);
//Xử lý khi request thành công
promise.then(function (result) {
  renderCity(result.data);
});

function renderCity(data) {
  for (const x of data) {
    citis.options[citis.options.length] = new Option(x.name, x.codename);
  }

  // xứ lý khi thay đổi tỉnh thành thì sẽ hiển thị ra quận huyện thuộc tỉnh thành đó
  citis.onchange = function () {
    district.length = 1;
    ward.length = 1;
    if (this.value != "") {
      const result = data.filter((n) => n.codename === this.value);

      for (const k of result[0].districts) {
        district.options[district.options.length] = new Option(
          k.name,
          k.codename
        );
      }
    }
  };

  // xứ lý khi thay đổi quận huyện thì sẽ hiển thị ra phường xã thuộc quận huyện đó
  district.onchange = function () {
    ward.length = 1;
    const dataCity = data.filter((n) => n.codename === citis.value);
    if (this.value != "") {
      const dataWards = dataCity[0].districts.filter(
        (n) => n.codename === this.value
      )[0].wards;

      for (const w of dataWards) {
        ward.options[ward.options.length] = new Option(w.name, w.codename);
      }
    }
  };
}

$(function () {
    $(document).ready(function () {
        $("#frmAddress").hide();
        $("#frmAddressUpdate").hide();
    });

    $(".add").click(function () {
        $("#frmAddress").toggle("show");
        $("#frmAddressUpdate").hide("slow");

        e.preventDefault();
    });

    $(".edit").click(function () {
        $("#frmAddressUpdate").toggle("show");
        $("#frmAddress").hide("slow");

        e.preventDefault();
    });




});

/* 
==================================================
API For Add New Address
==================================================
*/
var citis = document.getElementById("city");
var district = document.getElementById("district");
var ward = document.getElementById("ward");
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

/* 
==================================================
API For Update  Address
==================================================
*/
var citisu = document.getElementById("cityu");
var districtu = document.getElementById("districtu");
var wardu = document.getElementById("wardu");
var Parameteru = {
    url: "https://provinces.open-api.vn/api/?depth=3", //Đường dẫn đến file chứa dữ liệu hoặc api do backend cung cấp
    method: "GET", //do backend cung cấp
    responseType: "application/json", //kiểu Dữ liệu trả về do backend cung cấp
};
//gọi ajax = axios => nó trả về cho chúng ta là một promise
var promiseu = axios(Parameteru);
//Xử lý khi request thành công
promiseu.then(function (result) {
    renderCityu(result.data);
});

function renderCityu(data) {
    for (const x of data) {
        citisu.options[citisu.options.length] = new Option(x.name, x.codename);
    }

    // xứ lý khi thay đổi tỉnh thành thì sẽ hiển thị ra quận huyện thuộc tỉnh thành đó
    citisu.onchange = function () {
        districtu.length = 1;
        wardu.length = 1;
        if (this.value != "") {
            const result = data.filter((n) => n.codename === this.value);

            for (const k of result[0].districts) {
                districtu.options[districtu.options.length] = new Option(
                    k.name,
                    k.codename
                );
            }
        }
    };

    // xứ lý khi thay đổi quận huyện thì sẽ hiển thị ra phường xã thuộc quận huyện đó
    districtu.onchange = function () {
        wardu.length = 1;
        const dataCity = data.filter((n) => n.codename === citisu.value);
        if (this.value != "") {
            const dataWards = dataCity[0].districts.filter(
                (n) => n.codename === this.value
            )[0].wards;

            for (const w of dataWards) {
                wardu.options[wardu.options.length] = new Option(w.name, w.codename);
            }
        }
    };
}

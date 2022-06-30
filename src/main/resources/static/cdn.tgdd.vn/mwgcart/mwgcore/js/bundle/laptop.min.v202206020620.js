function addToCompare(n, t, i, r = false) {
  var c, d, v, o, u, f, s, l, g, y, p, nt, w, e, a, b, k, h;
  if (
    (t != undefined && t.preventDefault(),
    isFirstSS || showCompare(),
    (c = 3),
    closeTipCompare(),
    closeCompareBox(),
    $(".stickcompare label.error").hide(),
    (d =
      "<li class=formsg><a href='javascript:' class='cp-plus cp-plus_new' onclick='OpenPopup(this)'><i  class='icImageCompareNew'></i><p>Thêm sản phẩm</p></a>"),
    n <= 0)
  )
    return (
      (idcompare == undefined || idcompare.length <= 0) &&
        (createCookie("ck_idcompare", "", 30), $("#ss-now").hide()),
      !1
    );
  if (idcompare.indexOf(n) >= 0)
    return (
      r || cacheError("already"),
      (u = $(".listproduct *[data-id=" + n + "]").first()),
      (u == undefined || u.length <= 0) &&
        (u = $(".compare-popup *[data-id=" + n + "]").first()),
      u.find("a.item-ss").removeClass("active").html("<i></i> So sánh"),
      (e = $(".box02 *[data-id=" + n + "]").first()),
      e != undefined &&
        e.length > 0 &&
        e
          .removeClass("active")
          .html("<i class='icondetail-sosanh'></i> So sánh"),
      removeCompare(n),
      ClosePopup(),
      countCompare(),
      $(".stickcompare").length > 0 &&
        $(".stickcompare").is(":hidden") == !1 &&
        $("#ss-now").hide(),
      !1
    );
  if (
    ((v = !1),
    $(".listcompare li.formsg").remove(),
    (o =
      '<li id={id}><a href="javascript:void(0)" id="{id}"><img src="{image}" alt=""><h3>{manu}</h3></a><span class="remove-ic-compare" onclick="removeCompare({id},event);"><i class="iconcate-closess"></i></span></li>'),
    (u = $(".listproduct *[data-id=" + n + "]").first()),
    (u == undefined || u.length <= 0) &&
      (u = $(".compare-popup *[data-id=" + n + "]").first()),
    u.find("a.item-ss").addClass("active").html("<i></i> Đã thêm so sánh"),
    (e = $(".box02 *[data-id=" + n + "]").first()),
    e != undefined &&
      e.length > 0 &&
      e
        .addClass("active")
        .html("<i class='icondetail-sosanh'></i> Đã thêm so sánh"),
    u != undefined && u.length > 0 && (v = !0),
    i !== undefined
      ? ((u = $(i)),
        (f = u.data("href")),
        (s = u.data("img")),
        (l = u.data("name")))
      : ((f =
          u.find("a").attr("href") == "javascript:;"
            ? u.data("url")
            : u.find("a").attr("href")),
        (s = u.find(".item-img img").attr("src")),
        (l =
          u.find("a > h3").text() != ""
            ? u.find("a > h3").text()
            : u.find(".item-info h3").text()),
        u.find("a > h3").attr("title") !== undefined &&
          u.find("a > h3").attr("title") !== "" &&
          (l = u.find("a > h3").attr("title")),
        (s == undefined || s == "undefined") &&
          (s = u.find(".item-img img").attr("data-src"))),
    (y = f.indexOf("?")),
    (f = f.substring(0, y != -1 ? y : f.length)),
    (p = ""),
    (nt =
      urlcompare.length > 0
        ? urlcompare[0].slice(
            1,
            urlcompare[0].slice(1, -1).indexOf("index.html") + 1
          )
        : ""),
    f.charAt(0) == "/" &&
      ((w = f.replace(f.charAt(0), "").split("index.html")),
      w.length == 2 && (p = w[0])),
    urlcompare.length > 0 && nt.indexOf(p) < 0)
  )
    return (
      $(".listcompare li").each(function () {
        var n = parseInt($(this).attr("id"));
        n > 0 && removeCompare(n);
      }),
      cacheError("same"),
      addToCompare(n, t, i),
      !1
    );
  if (
    (v && localStorage.setItem("CompareCateName", document.cateName),
    idcompare.length >= c)
  )
    return (
      $(".listcompare li.formsg").remove(),
      cacheError("full"),
      u.parent("ul.pro-compare").length <= 0 &&
        u.find("a.item-ss").removeClass("active").html("<i></i> So sánh"),
      (e = $(".box02 *[data-id=" + n + "]").first()),
      e != undefined &&
        e
          .removeClass("active")
          .html("<i class='icondetail-sosanh'></i> So sánh"),
      !1
    );
  if (
    ((g = document.cateName !== undefined ? document.cateName : ""),
    idcompare.push(parseInt(n)),
    urlcompare.push(f.indexOf("index.html") === 0 ? f : "/" + f),
    (o = o.replace(/{id}/g, n)),
    (o = o.replace("{image}", s)),
    (o = o.replace("{manu}", l)),
    $(".stickcompare").length
      ? $(".stickcompare").addClass("spaceInDown").show()
      : ((a =
          document.isDesktop == !0
            ? "<div class='stickcompare stickcompare_new cp-desktop'><label class='error'></label><a href='javascript:;' onclick='clearCompare(event);' class='clearall'><i class='iconcate-closess'></i>Thu gọn</a><ul class='listcompare' data-catename='" +
              document.cateName +
              "'></ul></div> "
            : "<div class='stickcompare stickcompare_new'><label class='error'></label><ul class='listcompare' data-catename='" +
              document.cateName +
              "'></ul></div>"),
        (a = a.replace("{catename}", g.toLowerCase())),
        $("body").append(a)),
    $(".stickcompare").find("ul").append(o),
    $(".compare-box").length > 0 &&
      $(".compare-box > ul > li").length == 2 &&
      ((b = $(".compare-box > ul").html()),
      console.log(b),
      $(".compare-box").remove(),
      $(".stickcompare").find("ul").append(b)),
    idcompare.length < c)
  )
    for (k = 0; k <= c; k++)
      $(".stickcompare .listcompare li").length < c &&
        $(".stickcompare .listcompare").append(d);
  else idcompare.length == 3 && closeAddCmp();
  return (
    (h = !1),
    idcompare.length < 2 && (h = !0),
    createCookie("ck_idcompare", idcompare.toString(), 30),
    countCompare(),
    (isFirstSS = !1),
    $(".closecompare").remove(),
    document.isDesktop == !0
      ? $(".stickcompare").append(
          '<div class="closecompare"><a href="javascript:;" onclick="' +
            (h ? "" : "doCompare();") +
            '"class="doss' +
            (h ? " prevent" : "") +
            '">So sánh ngay</a><a href="javascript:;" onclick="RemoveAllIdCompare()" class="txtremoveall">Xóa tất cả sản phẩm</a></div>'
        )
      : $(".stickcompare").append(
          '<div class="closecompare"><a href="javascript:;" onclick="clearCompare(event);" class="clearall">Thu gọn</a><a href="javascript:;" onclick="' +
            (h ? "" : "doCompare();") +
            '"class="doss' +
            (h ? " prevent" : "") +
            '">So sánh ngay</a></div>'
        ),
    $(".stickcompare").addClass("spaceInDown").show(),
    ClosePopup(),
    $(".stickcompare").length > 0 &&
      $(".stickcompare").is(":hidden") == !1 &&
      $("#ss-now").hide(),
    !1
  );
}
function removeCompare(n, t) {
  var r, e, o, u, i, f;
  if (
    (t !== undefined && t.preventDefault(),
    (r = 3),
    $(".listcompare li.formsg").remove(),
    (e =
      "<li class=formsg><a href='javascript:' class='cp-plus cp-plus_new' onclick='OpenPopup(this)'><i class='icImageCompareNew'></i><p>Thêm sản phẩm</p></a>"),
    idcompare.indexOf(n) >= 0)
  ) {
    for (
      urlcompare.splice(idcompare.indexOf(n), 1),
        idcompare.splice(idcompare.indexOf(n), 1),
        createCookie("ck_idcompare", idcompare.toString(), 30),
        countCompare(),
        o = $(".listproduct *[data-id=" + n + "]").first(),
        o.find("a.item-ss").removeClass("active").html("<i></i> So sánh"),
        u = $(".box02 *[data-id=" + n + "]").first(),
        u != undefined &&
          u
            .removeClass("active")
            .html("<i class='icondetail-sosanh'></i> So sánh"),
        idcompare.length == 0
          ? clearCompare()
          : idcompare.length < 2 &&
            $(".stickcompare").find(".boxcompare").remove(),
        i = !1,
        idcompare.length < 2 && (i = !0),
        $(".stickcompare")
          .find("li#" + n)
          .remove(),
        $(".closecompare").remove(),
        f = 0;
      f <= r;
      f++
    )
      $(".stickcompare .listcompare li").length < r &&
        $(".stickcompare .listcompare").append(e);
    $(".stickcompare label.error").removeAttr("style").hide();
    document.isDesktop == !0
      ? $(".stickcompare").append(
          '<div class="closecompare"><a href="javascript:;" onclick="' +
            (i ? "" : "doCompare();") +
            '"class="doss' +
            (i ? " prevent" : "") +
            '">So sánh ngay</a><a href="javascript:;" onclick="RemoveAllIdCompare()" class="txtremoveall">Xóa tất cả sản phẩm</a></div>'
        )
      : $(".stickcompare").append(
          '<div class="closecompare"><a href="javascript:;" onclick="clearCompare(event);" class="clearall">Thu gọn</a><a href="javascript:;" onclick="' +
            (i ? "" : "doCompare();") +
            '"class="doss' +
            (i ? " prevent" : "") +
            '">So sánh ngay</a></div>'
        );
  }
  return !1;
}
function clearCompare() {
  $(".stickcompare").hide();
  document.isDesktop == !0 &&
    ($(".overlay").hide(), $(".overlay").removeClass("v2"));
  $(".stickcompare label.error").removeAttr("style").hide();
  var n = getCookie("ck_idcompare"),
    t = n != "" && n != null ? n.split(",") : [];
  t.length > 0
    ? ($("#ss-now").show(),
      document.isDesktop == !1 && document.productId > 0 && $("#ss-now").hide())
    : $("#ss-now").hide();
}
function showCompare(n, t, i = false) {
  var r, u;
  $(".stickcompare").length <= 0 &&
    ((r = getCookie("ck_idcompare")),
    r !== "" && r !== null
      ? getCompareListByListID(r, n > 0 ? n : 0, t)
      : n > 0 && t !== undefined
      ? getCompareListByListID(n, 0, t, i)
      : $(".box02__right").length > 0 &&
        ((u = $(".box02__right").data("id")),
        u > 0 &&
          ($(".stickcompare").length <= 0
            ? showCompare(u, "div.box02__right", !0)
            : addToCompare(u, event, "div.box02__right"))));
  $(".stickcompare").show();
  isFirstSS && $("#ss-now").append(appendLoadingViewMore());
  $(".stickcompare label.error").removeAttr("style").hide();
  $(".stickcompare").length > 0 &&
    $(".stickcompare").is(":hidden") == !1 &&
    $("#ss-now").hide();
}
function doCompare(n) {
  var t = document.cateUrl,
    i,
    r,
    u;
  return (
    t !== "" && urlcompare.length >= 2
      ? (urlcompare[0].indexOf(t) < 0 &&
          urlcompare[1].indexOf(t) < 0 &&
          (t = urlcompare[0].slice(
            1,
            urlcompare[0].slice(1, -1).indexOf("index.html") + 1
          )),
        (i = "itm_source=so-sanh-trang-nganh-hang"),
        n !== undefined &&
          n == !0 &&
          (i = "itm_source=goi-y-so-sanh-trang-nganh-hang"),
        (r = ""),
        (r =
          idcompare.length == 3
            ? "?productid=" + idcompare[2] + "&" + i
            : "?" + i),
        (u =
          "/" +
          t +
          "/" +
          urlcompare[0].replace("/" + t + "/", "") +
          "-vs-" +
          urlcompare[1].replace("/" + t + "/", "") +
          r),
        $(".stickcompare").remove(),
        $(".box02__right").length <= 0 && loadingRedirect(),
        (window.location = u),
        (idcompare = []),
        (urlcompare = []))
      : cacheError("least"),
    !1
  );
}
function setProductIdCompare(n, t) {
  $.ajax({
    url: "/Category/SetProductIdCompare",
    type: "POST",
    data: { id: n },
    cache: !1,
    beforeSend: function () {},
    success: function () {
      loadingRedirect();
      window.location = t;
    },
    error: function () {
      loadingRedirect();
      window.location = t;
    },
  });
}
function closeCompareBox() {
  $(".compare-box").length > 0 &&
    ($(".compare-box").remove(), $("#notifychatmsg").show());
}
function callCompareSuggestion(n) {
  typeof showSuggest != "undefined" &&
    showSuggest == "true" &&
    (n == undefined || n === !0) &&
    ($("#lstp .cate > li").each(function () {
      var n = parseInt($(this).find("a").first().data("pid"));
      n > 0 && addToCompareAuto(n);
    }),
    idcompare.length >= 2 && $(window).scrollTop() > 100
      ? $(".compare-box").show("slow")
      : $(".compare-box").hide());
}
function addToCompareAuto(n, t, i) {
  t != undefined && t.preventDefault();
  $("ul.listcompare").find("li").length > 0 &&
    idcompare.length > 0 &&
    ((urlcompare = []), (idcompare = []), $(".stickcompare").remove());
  var u = $(".cate a[data-pid='" + n + "']"),
    r;
  return (i == undefined
    ? (r = u.attr("href"))
    : ((u = $(i)), (r = u.attr("data-src"))),
  urlcompare.length > 0 &&
    r.indexOf(
      urlcompare[0].slice(
        1,
        urlcompare[0].slice(1, -1).indexOf("index.html") + 1
      )
    ) < 0)
    ? !1
    : ((idcompare[idcompare.length] = parseInt(n)),
      (urlcompare[urlcompare.length] =
        r.indexOf("index.html") === 0 ? r : "/" + r),
      $(".compare-box > p > span").html(idcompare.length),
      !1);
}
function closeTipCompare(n) {
  n != undefined && n.preventDefault();
  $(".cate li .tip-abs.show").length > 0 &&
    ($(".cate li .tip-abs").next().show(), $(".cate li .tip-abs").remove());
}
function showTipCompare() {
  var n = $(".locationbox__popup:visible").length == 0,
    t = getCookie("DMX_CompareTip");
  t == null &&
    typeof isShowTipCompare != "undefined" &&
    isShowTipCompare.toString().toLowerCase() === "true" &&
    $(window).scrollTop() > 150 &&
    $("#lstp .cate > li").length <= 10 &&
    n &&
    ($(".cate li .tip-abs").append(
      '<div class="overlaytip" onclick="closeTipCompare(event)"></div>'
    ),
    setTimeout(function () {
      $(".cate li .tip-abs").addClass("show");
      $("html,body").animate(
        { scrollTop: $(".cate li .tip-abs").offset().top - 300 },
        "slow"
      );
      $(".cate li .tip-abs").next().hide();
      createCookie("DMX_CompareTip", 1, 365);
    }, 2e3),
    (isShowTipCompare = !1));
}
function loadPopupAddProd() {
  $(".addcompare").length
    ? $("#suggestss").show()
    : ($("body").append(
        "<div id=suggestss><div class=overlay></div><div class='addcompare' onsubmit='return false;'><label>Mời bạn nhập tên sản phẩm</label><input id='kcc' type='text' onsubmit='return false;' placeholder='Nhập tên sản phẩm' autocomplete='off' autofocus='' /><a class=closeacp href=javascript: onclick=closeAddCmp()>&#10006;</a></div></div>"
      ),
      $(".overlay").show());
  initSuggest();
}
function closeAddCmp() {
  $("#suggestss").hide();
  $(".overlay").hide();
}
function initSuggest() {
  function t() {
    $(".input-text i.iconcate-closess").show();
    $(".autocomplete").show();
    $("#loading-compare").length <= 0 &&
      $(".autocomplete").append(appendLoadingCompare());
    $("#loading-compare").show();
  }
  function n() {
    $(".autocomplete").hide();
    $("#loading-compare").hide();
  }
  if (document.getElementById("kcc") != undefined) {
    isInitSuggest = !0;
    var i = AutoComplete.defaults.KeyboardMappings;
    i.Enter.Callback = function () {
      return;
    };
    return;
  }
}
function appendLoadingCompare() {
  return '<div id="loading-compare"><p class="ccsslder"><span class="ccsswrap"><span class="ccssdot"></span><span class="ccssdot"></span><span class="ccssdot"></span></span></p></div>';
}
function getCompareListByListID(n, t, i, r = false) {
  $.ajax({
    url: "/Category/SuggestForCompareBoxOnCategory",
    type: "GET",
    data: { key: "", cid: document.cateID, lstProductID: n },
    cache: !1,
    beforeSend: function () {},
    success: function (n) {
      if (n !== null && n !== "") {
        var u = $(n).find("li");
        $("#ss-now .stage").remove();
        u !== undefined &&
          (u.each(function () {
            addToCompare($(this).data("id"), null, this);
          }),
          createCookie("ck_idcompare", idcompare.toString(), 30),
          $(".stickcompare").addClass("spaceInDown").show());
      }
      i !== undefined && t > 0
        ? addToCompare(t, event, "div.box02__right", r)
        : t > 0 && addToCompare(t);
    },
    error: function (n) {
      console.log(n);
    },
  });
}
function countCompare() {
  var t = getCookie("ck_idcompare"),
    n;
  let i = !1;
  t !== "" &&
    t !== null &&
    ((n = t.split(",")),
    n.length > 0
      ? ((i = !0),
        $(".sticky-bar-ss").length > 0
          ? isMobile
            ? $(".sticky-bar-ss span").text("(" + n.length + ")")
            : $(".sticky-bar-ss").append(
                "<span class='sticky-bar-number'>" + n.length + "</span>"
              )
          : ($(".stickcompare").length > 0 &&
            $(".stickcompare").is(":hidden") == !1
              ? $("#ss-now").hide()
              : $("#ss-now").show(),
            document.isDesktop == !1 &&
              document.productId > 0 &&
              $("#ss-now").hide(),
            $("#count-ss").text("(" + n.length + ")")))
      : $(".sticky-bar-ss .sticky-bar-number").length > 0 &&
        $(".sticky-bar-ss .sticky-bar-number").remove());
  i ||
    ($(".sticky-bar-ss").length == 0
      ? $("#ss-now").hide()
      : isMobile
      ? $(".sticky-bar-ss span").text("")
      : $(".sticky-bar-ss .sticky-bar-number").remove());
}
function cacheError(n) {
  var t = "",
    i;
  switch (n) {
    case "full":
      t = "Vui lòng xóa bớt sản phẩm để tiếp tục so sánh!";
      break;
    case "least":
      t = "Bạn phải chọn ít nhất 2 sản phẩm để có thể so sánh!";
      break;
    case "already":
      t = "Bạn đã chọn sản phẩm này rồi, vui lòng chọn sản phẩm khác!";
      break;
    case "same":
      i = localStorage.getItem("CompareCateName");
      i = i == null || i == undefined ? "Sản phẩm" : capitalizeFirstLetter(i);
      t =
        "Chỉ có thể so sánh sản phẩm cùng nhóm hàng. " +
        i +
        " đã được xoá khỏi giỏ so sánh.";
  }
  t !== "" &&
    ($(".stickcompare label.error").show().text(t).animate({ opacity: 1 }, 800),
    $(".stickcompare").length > 0 &&
      $(".stickcompare").is(":hidden") &&
      $(".errorcompare").text(t).show(),
    setTimeout(function () {
      $(".stickcompare label.error").hide();
      $(".errorcompare").text("").hide();
    }, 4e3));
}
function appendLoadingViewMore() {
  return '<div class="stage"><div class="dot-stretching"></div></div>';
}
function OpenPopup(n) {
  var e, t, i, f, r, u;
  if (flagOpenPopup) return !1;
  if (((flagOpenPopup = !0), idcompare.length >= 3))
    return cacheError("full"), !1;
  if (
    ($(n).append(appendLoadingViewMore()),
    (e = document.cateID),
    (t = localStorage.getItem("viewedHistory")),
    t != null &&
      !JSON.stringify(t).includes("proId") &&
      !JSON.stringify(t).includes("cateId"))
  )
    return localStorage.removeItem("viewedHistory"), !1;
  if (
    ((t = JSON.parse(t)),
    (u = []),
    (i = t != null ? t.filter((n) => n.cateId == e) : null),
    i != null && i.length > 0)
  ) {
    for (f = [], r = 0; r < i.length; r++)
      i[r] !== "" && i[r] !== null && i[r].proId !== undefined && f.push(i[r]);
    u = f.map((n) => n.proId);
    u.length > 3 && (u = u.slice(0, 3));
  }
  $("#dlding").show();
  $.ajax({
    url: "/Compare/OpenPopup",
    type: "POST",
    data: { productIds: u },
    cache: !0,
    success: function (t) {
      $("#dlding").hide();
      $(n).find(".stage").remove();
      flagOpenPopup = !1;
      $(".popup-addsp").show();
      t != null && t.errorCode == 1
        ? ($(".popup-addsp .pro-compare_viewed").html(t.html),
          t.html == "" && t.html.trim() == ""
            ? $(".compare-popup h4").hide()
            : $(".compare-popup h4").show(),
          RemoveOnclickHtml($(".pro-compare li a.pro-nrview")),
          RemoveOnclickHtml($(".pro-compare li a:first-child")),
          CheckButtonCompareCategory())
        : $(".compare-popup h4").hide();
    },
  });
}
function ClosePopup() {
  $(".popup-addsp").hide();
  $(".popup-addsp .pro-compare_search").html("").hide();
  $(".popup-addsp .pro-compare_viewed").html("");
  $("#searchproductcompare input").val("");
}
function SearchProductCompare(n, t) {
  $(".pro-compare_search").hide();
  var r = document.cateID,
    i = $(n).val();
  if (i == "" || i.length < 2 || r <= 0) return !1;
  if ((typeof t == "undefined" && (t = !1), !t))
    return (
      clearTimeout(timmer),
      (timmer = setTimeout(function () {
        SearchProductCompare(n, !0);
      }, 300)),
      !1
    );
  $.ajax({
    url: "/Compare/SearchProductCompare",
    type: "POST",
    data: { categoryId: r, keyword: i, hasWebStatusList: !0 },
    cache: !0,
    success: function (t) {
      $(".pro-compare_search").show();
      t != null && t.errorCode == 1 && t.html != ""
        ? ($(".pro-compare_search").html(t.html),
          RemoveOnclickHtml($(".pro-compare li a.pro-nrview")),
          RemoveOnclickHtml($(".pro-compare li a:first-child")),
          CheckButtonCompareCategory())
        : $(".pro-compare_search").html(
            "<li class='text-center'>Không tìm thấy kết quả cho từ khóa: <b>" +
              t.keyword +
              "</b></li>"
          );
      $(n).val(t.keyword);
    },
  });
}
function RemoveOnclickHtml(n) {
  n.each(function () {
    $(this).attr("onclick", null);
    $(this).hasClass("pro-nrview") && $(this).addClass("item-ss");
  });
}
function RemoveAllIdCompare() {
  createCookie("ck_idcompare", "", 30);
  idcompare = [];
  $(".stickcompare.stickcompare_new .listcompare").html("");
  $(".closecompare").remove();
  $("a.item-ss").each(function () {
    $(this).removeClass("active").html("<i></i> So sánh");
  });
  $(".box02").each(function () {
    $(this)
      .find(".box02__right")
      .removeClass("active")
      .html("<i class='icondetail-sosanh'></i> So sánh");
  });
  ClosePopup();
  clearCompare();
  closeCompareBox();
  countCompare();
}
function capitalizeFirstLetter(n) {
  return n.charAt(0).toUpperCase() + n.slice(1);
}
function getCookie(n) {
  var i = document.cookie,
    u = n + "=",
    t = i.indexOf("; " + u),
    r;
  if (t == -1) {
    if (((t = i.indexOf(u)), t != 0)) return null;
  } else
    (t += 2), (r = document.cookie.indexOf(";", t)), r == -1 && (r = i.length);
  return decodeURI(i.substring(t + u.length, r));
}
function initCompareFunc() {
  $(".item-ss").click(function () {
    console.log("item-ss -- click");
    $(".content-ss").toggleClass("active");
  });
  $(".btn-ss--close").click(function () {
    $(".content-ss").removeClass("active");
  });
  $(document).on("click", "a.item-ss", function () {
    var n = $(this).parents(".item").data("id"),
      r,
      i,
      t,
      u;
    n > 0 &&
      ((r = !1),
      $(".stickcompare").length <= 0 &&
        ((i = getCookie("ck_idcompare")),
        i !== "" &&
          i !== null &&
          ((t = i.split(",")),
          t.indexOf(n.toString()) >= 0
            ? ((u = t.indexOf(n.toString())),
              t.splice(u, 1),
              (n = 0),
              $(this).removeClass("active").html("<i></i> So sánh"))
            : $(this).addClass("active").html("<i></i> Đã thêm so sánh"),
          t.length > 0 && ((r = !0), getCompareListByListID(t.toString(), n)))),
      r || addToCompare(n));
  });
  countCompare();
}
function replaceListProductSmartWatchPage() {
  console.log("replaceListProductSmartWatchPage_v5");
  $(".block").each(function () {
    $(this).find(".hdf").val($(this).find(".listproduct").html());
  });
  $(document).on("click", ".block__tab li", function (n) {
    var r, s, t, h, u, c, f, e, o, i;
    if ((n.preventDefault(), !$(this).hasClass("active"))) {
      if (
        ($(this).parent().find("li").removeClass("active"),
        $(this).addClass("active"),
        (r = $(this).find("a").html()),
        r.toLowerCase() === "nổi bật" && (r = $(this).attr("data-txtDefaut")),
        $(this)
          .parent()
          .parent()
          .find(".block-btn span")
          .html("Xem tất cả laptop " + r),
        $(this)
          .parent()
          .parent()
          .find(".block-btn")
          .attr("href", $(this).attr("data-lnk")),
        (s = document.cateID),
        $(this).data("cate") === 7978 &&
          ((s = "7978"),
          $(this)
            .parent()
            .parent()
            .find(".block-btn span")
            .html("Xem tất cả " + $(this).attr("data-txtDefaut"))),
        (t = $(this).parent().parent().find(".listproduct")),
        $(this).data("type") === "h")
      ) {
        t.html($(this).parent().parent().find(".hdf").val());
        return;
      }
      h = 0;
      u = !1;
      $(this).data("type") === "m" && (u = !0);
      c = !1;
      $(this).data("type") === "pr" && (c = !0);
      f = $(this).data("prop");
      u && (h = f);
      e = $(this).data("prop");
      f !== undefined &&
        f != "" &&
        ((t = $(this).parent().parent().find(".listproduct")),
        (o = $(this).parent().parent().prop("id")),
        t.length == 1 &&
          ((i = {
            CategoryId: s,
            PageSize: 10,
            StrPropID: e,
            ManuId: h,
            IsSmartWatchPage: !0,
          }),
          u && (i.StrPropID = ""),
          c && (i.StrPropID = ""),
          e === 590
            ? (i.StrListRangeId = "590")
            : e === 591 && (i.StrListRangeId = "591"),
          $.ajax({
            url: "/Category/GetProductListLandingPage",
            type: "POST",
            data: i,
            cache: !0,
            beforeSend: function () {
              $("#preloader").show();
            },
            success: function (n) {
              $("#preloader").hide();
              n != ""
                ? (t.html(n),
                  $("#" + o + " .listproduct .item").length < 10
                    ? $("#" + o + " .block-btn")
                        .removeClass("hide")
                        .addClass("hide")
                    : $("#" + o + " .block-btn").removeClass("hide"))
                : t.find("li").remove();
            },
            error: function (n) {
              console.log(n);
            },
          })));
    }
  });
}
function loadingRedirect() {
  $("#progressTop").remove();
  $(".overlay").show();
  $("body").append($("<div><b></b><i></i></div>").attr("id", "progressTop"));
  $("#progressTop").width("105%");
}
function CloseCriteria(n) {
  $(n).parents(".block").find(".block__banner ._criteria > div").toggle();
}
var idcompare = [],
  urlcompare = [],
  isInitSuggest = !1,
  isFirstSS = !0,
  flagOpenPopup,
  createCookie;
$(document).ready(function () {
  $(document).on("click", "#kcc", function () {
    isInitSuggest || initSuggest();
  });
  $(document).on("click", ".close-comppare", function () {
    clearCompare();
  });
  if (document.isDesktop == !0)
    $(document).on("click", ".overlay.v2", function () {
      clearCompare();
    });
  $(document).on("click", ".input-text i.iconcate-closess", function () {
    $("#kcc").val("");
    $(".autocomplete").hide();
    $(".input-text i.iconcate-closess").hide();
  });
  $(document).on("click", ".listcompare .cp-plus.cp-plus_new", function () {});
});
let getHeight = 0;
globalEvent.on("autocomplete", initSuggest);
flagOpenPopup = !1;
$(document).ready(function () {
  console.log("smartwatch_3");
  $(".slider-bannertop").owlCarousel({
    items: 1,
    loop: !1,
    rewind: !0,
    dots: !0,
    autoplay: !0,
    lazyLoad: !0,
    nav: !0,
    autoplayTimeout: 2e3,
    autoplayHoverPause: !0,
  });
  $(".listproduct-deal").owlCarousel({
    items: 5,
    dots: !1,
    margin: 8,
    nav: !0,
    slideBy: "page",
    rewind: !0,
    smartSpeed: 100,
  });
  $(".deal-banner").owlCarousel({
    items: 2,
    dots: !1,
    margin: 10,
    slideBy: 1,
    rewind: !0,
    nav: !0,
    smartSpeed: 100,
    autoplay: !0,
    autoplayTimeout: 5e3,
    autoplayHoverPause: !0,
  });
  $(".trademark-slider").owlCarousel({
    nav: !0,
    items: 4,
    dots: !1,
    margin: 15,
    rewind: !0,
    lazyLoad: !0,
  });
  $(".block__banner a").attr("href", "javascript:;");
  replaceListProductSmartWatchPage();
  initCompareFunc();
  new StickyNavigation();
  let n = decodeURIComponent(getCookie("prevUrl"));
  if (n != null && n == "/laptop") {
    let n = document.createElement("script");
    n.src = "lib/hot-jar/hot-jar.js";
    $("head").append(n);
  } else setCookie("prevUrl", window.location.pathname, 1);
});
createCookie = function (n, t, i) {
  var u, r;
  i
    ? ((r = new Date()),
      r.setTime(r.getTime() + i * 864e5),
      (u = "; expires=" + r.toGMTString()))
    : (u = "");
  document.cookie = n + "=" + t + u + "; path=/";
};
$(window).scroll(function () {
  var n = $(window).scrollTop();
  n >= 290
    ? $(".menu-top").addClass("fixed")
    : $(".menu-top").removeClass("fixed");
});
class StickyNavigation {
  constructor() {
    this.currentId = null;
    this.currentTab = null;
    this.tabContainerHeight = 110;
    this.lastScroll = 0;
    let n = this;
    $(".nav-item").click(function (t) {
      n.onTabClick(t, $(this));
    });
    $(window).scroll(() => {
      this.onScroll();
    });
  }
  onTabClick(n, t) {
    n.preventDefault();
    let i = $(t.attr("href")).offset().top - this.tabContainerHeight + 1;
    $("html, body").animate({ scrollTop: i }, 600);
  }
  onScroll() {
    this.findCurrentTabSelector();
    this.lastScroll = $(window).scrollTop();
  }
  findCurrentTabSelector() {
    let n,
      t,
      i = this;
    $(".nav-item").removeClass("active");
    $(".nav-item").each(function () {
      let r = $(this).attr("href"),
        u = $(r).offset().top - i.tabContainerHeight,
        f = $(r).offset().top + $(r).height() - i.tabContainerHeight;
      $(window).scrollTop() > u &&
        $(window).scrollTop() < f &&
        ((n = r), (t = $(this)), $(this).addClass("active"));
    });
    (this.currentId != n || this.currentId === null) &&
      ((this.currentId = n), (this.currentTab = t));
  }
}

'use strict'
$(function() {
	// 税率計算
	function taxCalc(price, tax) {
		return parseInt(Math.floor(price * tax));
	}

	// HTMLの分類分けdivからクラス名を取得する
	let category = [];
	for (let i = 0; i < $("div.tax8 div").length; i++) {
		category.push($(`div.tax8 div:nth-child(${i + 1})`).attr("class"));
	}
	for (let i = 0; i < $("div.tax10 div").length; i++) {
		category.push($(`div.tax10 div:nth-child(${i + 1})`).attr("class"));
	}

	// ボタンを追加する処理
	$("ul button").on("click", function(e) {
		let name = e.target.className;
		$(this).before(`<li><input type="number" name="${name}" class="input ${name}"></li>`);
		focus()
	})
	// 全てクリア
	function clear() {
		$(".input").val(0);
		$(".output").text(0);
		$("input[name='comment']").val("");
		$.each(category, function(index, ele) {
			$(`p.${ele}`).text(0);
		})
	}
	$(".delete").on("click", function() {
		clear();
		focus();
	})

	// 初期値0を入力+初期値の間は文字色をグレー+フォーカスしたら文字色を黒色
	function focus() {
		for (let ele of $(".input")) {
			if (!parseInt($(ele).val()) >= 1) {
				$(ele).val(0).css("color", "#CCC").on("focus", function() {
					$(this).val("").css("color", "#000");
				}).blur(function() {
					if ($(this).val() === "" || $(this).val() == 0) {
						$(this).val(0).css("color", "#CCC").on("focus", function() {
							$(this).val("").css("color", "#000");
						})
					}
				})
			}
		}
	}
	// 呼び出し
	focus()

	// 計算部分
	$(".calc,input[type='submit']").on("click", function() {
		let values = [];
		let subTtl = 0;
		let tax8 = 0;
		let tax10 = 0;
		$.each(category, function(index, ele) {
			// let cate = $(`div.${ele}`)
			let cateSize = $(`div.${ele} input`).length;
			// console.log(cateSize);
			for (let i = 0; i < cateSize; i++) {
				values.push($(`input.${ele}:eq(${i})`).val());
			}
			$.each(values, function(index, num) {
				subTtl += parseInt(num);
			})
			values = [];
			if ($("input[name='tax']:checked").val() == "before") {
				if (index < $("div.tax8 div").length) {
					tax8 += parseInt(subTtl);
					$(`p.${ele}`).text(subTtl);
					$(`input.${ele}[type="hidden"]`).val(subTtl);
				} else {
					tax10 += parseInt(subTtl);
					$(`p.${ele}`).text(subTtl);
					$(`input.${ele}[type="hidden"]`).val(subTtl);
				}
			} else {
				if (index < $("div.tax8 div").length) {
					tax8 += parseInt(subTtl);
					$(`p.${ele}`).text(taxCalc(subTtl, 1.08));
					$(`input.${ele}[type="hidden"]`).val(taxCalc(subTtl, 1.08));
				} else {
					tax10 += parseInt(subTtl);
					$(`p.${ele}`).text(taxCalc(subTtl, 1.1));
					$(`input.${ele}[type="hidden"]`).val(taxCalc(subTtl, 1.1));
				}
			}
			subTtl = 0;
		})
		if ($("input[name='tax']:checked").val() == "before") {
			$("p.Tax8").text(tax8);
			$("p.Tax10").text(tax10);
			$("p.Total").text(tax8 + tax10);
			if ($("input[name='comment']").val() === "") {
				$("input[name='comment']").val(tax8 + tax10);
			}else{
				let userInput = $("input[name='comment']").val();
				$("input[name='comment']").val(userInput +" "+ (tax8 + tax10));
			}
			
		} else {
			let taxTotal = taxCalc(tax8, 1.08) + taxCalc(tax10, 1.1);
			$("p.Tax8").text(taxCalc(tax8, 1.08));
			$("p.Tax10").text(taxCalc(tax10, 1.1));
			$("p.Total").text(taxTotal);
			
			if ($("input[name='comment']").val() === "") {
				$("input[name='comment']").val(taxTotal);
			}else{
				let userInput = $("input[name='comment']").val();
				$("input[name='comment']").val(userInput +" "+ taxTotal);
			}
		}
	})

	//コメントテキスト追加ボタン
	$("#addComment button").on("click", function() {
		if ($("input[name='comment']").val() === "") {
			let text = $(this).text();
			$("input[name='comment']").val(text + " ");
		} else {
			let userInput = $("input[name='comment']").val();
			let text = $(this).text();
			let output = text + " " + userInput;
			$("input[name='comment']").val(output);
		}
	})







})
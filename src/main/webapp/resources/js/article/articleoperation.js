/**
 * 
 */
$(function() {
	var initUrl = '/iBlog/articleadmin/getarticleinitinfo';
	var addArticleUrl = '/iBlog/articleadmin/addarticle';
	getArticleInitInfo();
	function getArticleInitInfo() {
		$.getJSON(initUrl, function(data) {
			if (data.success) {
				var tempHtml = '';
				data.articleCategoryList.map(function(item, index) {
					tempHtml += '<option data-id="' + item.articleCategoryId
							+ '">' + item.articleCategoryName + '</option>';
				});
				$('#article-category').html(tempHtml);
			}
		});
	}

	$('#submin').click(
			function() {
				var article = {};
				article.articleName = $('#article-name').val();
				article.articleDesc = $('#article-desc').val();
				article.articleContent = $('#article-content').val();
				article.articleCategory = {
					articleCategoryId : $('#article-category').find('option')
							.not(function() {
								return !this.selected;
							}).data('id')
				};
				var formData = new FormData();
				formData.append('articleStr', JSON.stringify(article));
				$.ajax({
					url : addArticleUrl,
					type : 'POST',
					data : formData,
					contentType : false,
					processData : false,
					cache : false,
					success : function(data) {
						if (data.success) {
							$.toast('提交成功！');
						} else {
							$.toast('提交失败！' + data.errMsg);
						}
					}
				})
			});
})
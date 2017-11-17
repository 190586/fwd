/*-----------------------------------------------------------------------------------*/
/*	Login.js
/*-----------------------------------------------------------------------------------*/
var Login = function () {
	return {
		initialize: function(isLogin) {
			var _this = this;
			if(isLogin) {
				$('#login-warning').hide();
				$('#loginform').validate({
					submitHandler: function(form) {
						_this.login();
					}
				});
			} else {
				$('.sign-out-button').on('click', function(evt){
					evt.preventDefault();
					_this.logout();
				});
			}
		},
		checkLS: function() {
			try {
				localStorage.setItem('test', 'test');
				localStorage.removeItem('test');
				return true;
			} catch(e) {
				return false;
			}
		},
		logout: function(func) {
			if(this.checkLS()) {
				localStorage.removeItem('t');
				localStorage.removeItem('r');
			} else {
				$.removeCookie('t');
				$.removeCookie('r');
			}
			window.location = '/login';
		},
		auth: function(callback) {
			if(this.checkLS()) {
				if(localStorage.getItem('t') && localStorage.getItem('r')) {
					callback();
					return;
				}
			} else {
				if($.cookie('t') && $.cookie('r')) {
					callback();
					return;
				} 
			}
			window.location = '/login';
		},
		login: function() {
			var _this = this;
			$('#login-warning').hide();
			$('#login-button').attr('disabled', true);
			var username = $('#username').val();
			var password = $('#password').val();
			var url = 'oauth/token?grant_type=password&username='+ username +'&password='+ password;
			$.ajax({
				'dataType' : 'json',
				'type' : 'GET',
				'url' : url,
				'beforeSend' : function (xhr){ 
					xhr.setRequestHeader('Authorization', 'Basic dGFsZW50czpzZWNyZXQ='); 
				},
				'success' : function(data) {
					if(data.access_token != null) {
						if(_this.checkLS()) {
							localStorage.setItem('t', data.access_token);
							localStorage.setItem('r', data.refresh_token);
						} else {
							$.cookie("t", data.access_token);
							$.cookie("r", data.refresh_token);
						}
						window.location = '/admin/pages';
					}
				},
				'error' : function(data) {
					$('#login-warning').show();
					$('#login-button').attr('disabled', false);
				}
			});
		}
	}
}();
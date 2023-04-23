<style lang="scss">
	/* 注意要写在第一行，同时给style标签加入lang="scss"属性 */
	@import "@/uni_modules/uview-ui/index.scss";
</style>

<script>
	import app_upgrade from '@/uni_modules/app-upgrade/js_sdk/index.js';
	import request from './utils/request';
	export default {
		onLaunch: function() {
			console.log('App Launch');
			app_upgrade(async (versionCode) => {
				//查询是否更新
				console.log("查询是否更新")
				const mydata = await uni.request({
					url: 'http://43.142.110.71:2020/app/checkUpdate',
					data: {
						'versionCode': versionCode
					},
					method: 'POST'
				})

				console.log(mydata[1].data)
				if(mydata[1].data.code == 200){
					return {
						// changelog:data.changelog,
						// status:data.status, // 0 无新版本 | 1 有新版本
						// path:data.path // 新apk地址
						changelog: mydata[1].data.data.content,
						status: mydata[1].data.data.type, // 0 无新版本 | 1 有新版本
						path: mydata[1].data.data.url // 新apk地址
					}
				}


			})
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		}
	}
</script>

<style>
	@import "colorui/main.css";
	@import "colorui/icon.css";

	/*每个页面公共css */
	html {
		width: 100%;
		height: 100%;
	}

	body {
		width: 100%;
		height: 100%;
	}

	#app {
		width: 100%;
		height: 100%;
	}
</style>
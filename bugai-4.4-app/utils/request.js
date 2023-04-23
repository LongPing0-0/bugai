// const BASE_URL = 'http://localhost:2020'
const BASE_URL = 'http://43.142.110.71:2020'

export const request = (options) =>{
	return new Promise((resolve,reject)=>{
		uni.request({
			url: BASE_URL+options.url,
			method: options.method || 'GET',
			header:{
				//token: uni.getStorageSync('JWT')?uni.getStorageSync('JWT').token:''
				'content-type': 'application/json;charset:utf-8',
				'Authorization': uni.getStorageSync('JWT')?uni.getStorageSync('JWT'):''
			},
			data: options.data || {},
			success: (res)=>{
				console.log("JWT")
				console.log(uni.getStorageSync("JWT"))
				console.log("success")
				console.log(BASE_URL+options.url)
				console.log("method"+options.method)
				const data = res.data
				if(data.code == '401'){
					console.log("未授权")
					
					let curPage = getCurrentPages();
					let route = curPage[curPage.length - 1].route;
					console.log("当前路由"+route)
					uni.showToast({
						icon: 'none',
						title: data.msg
					})
					if(route != "pages/signup/login" && route != "pages/signup/index"){
						uni.navigateTo({
							url: '/pages/signup/index'
						})
					}

				}else if(data.code != '200'){
					uni.showToast({
						icon: 'none',
						title: data.msg
					})
				}
				resolve(data)
			},
			fail: (error)=>{
				console.log("error")
				uni.showToast({
					icon: 'none',
					title: '系统错误！'
				})
				reject(error)
			}
		})
	})
}

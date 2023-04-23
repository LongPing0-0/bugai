<template>
	<view id="app">
			
			<view class="tupian">
				<image :src='jisuanjieguotupian' alt=""></image>
			</view>
		
		

	<!-- <image class="tupian"  src="/static/venn.png" alt="VENN"></image> -->
	<!-- <view><img src="B" alt="B"></view> -->
	  <view class="calculator">
	    <view class="result" style="grid-area: result">
	      {{ equation }}
	    </view>
		<view class="result1" style="grid-area: result1">
		  {{ equation1 }}
		</view>
	
	    <button style="grid-area: A" @click="append('A')">A</button>
	    <button style="grid-area: B" @click="append('B')">B</button>
	    <button style="grid-area: C" @click="append('C')">C</button>
	    <button style="grid-area: equal" @click="calculate">=</button>
	    <button style="grid-area: Bing" @click="append('⋃')">⋃</button>
	    <button style="grid-area: Jiao" @click="append('⋂')">⋂</button>
	    <button style="grid-area: Kongji" @click="append('ϕ')">ϕ</button>
	    <button style="grid-area: Quanji" @click="append('Ω')">Ω</button>
	    <button style="grid-area: clear" @click="clear">AC</button>
	    <button style="grid-area: A̅" @click="append('A̅')">A̅</button>
	    <button style="grid-area: B̅" @click="append('B̅')">B̅</button>
	    <button style="grid-area: C̅" @click="append('C̅')">C̅</button>
	  </view>
	</view>
</template>

<script>
	export default {
		name: "vennJiSuanQi",
		data() {
			return {
				equation:'0',
				equation1:'',
				// VENN:'venn.png',
				// B:
				isDecimalAdded: false,
				isOperatorAdded: false,		//运算符
				isStarted: false,
				isNumberAdded:false,
				jisuanjieguotupian: "/static/jisuanqitupian/origin.png",
			}
		},
		methods: {
			 // Check if the character is ⋃ / ⋂
			 isOperator(character) {
			   return ['⋃', '⋂'].indexOf(character) > -1
			 },
			 // When pressed Operators or Numbers
			 isA(){},
			 isB(){},
			 append(character) {
			   // Start
			   if (this.equation === '0' && !this.isOperator(character)) {
			     this.equation = '' + character
			     this.isStarted = true
			     return
			   }
	
			   // If Number
			   if (!this.isOperator(character)) {
			     this.equation += '' + character
				this.isNumberAdded = false
			   }
			   
			   // Added Operator
			   if (this.isOperator(character) && !this.isNumberAdded) {
			     this.equation += '' + character
				 console.log("isOperator:"+character)
			     this.isNumberAdded = true
			   }
			 },
			 // When pressed '='
			 calculate() {
				if (this.equation == 'A⋃A' || this.equation == 'A⋂A' || this.equation == 'A⋂ϕ' 
				|| this.equation == 'A⋃ϕ' || this.equation == 'ϕ⋃A' || this.equation == 'ϕ⋂A' 
				|| this.equation == 'A⋂Ω' || this.equation == 'Ω⋂A'){
					this.equation1 = 'A';
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/onlyA.png")
					
				}else if (this.equation == 'B⋃B' || this.equation == 'B⋂B' || this.equation == 'B⋂ϕ'
				|| this.equation == 'B⋃ϕ' || this.equation == 'ϕ⋃B' || this.equation == 'ϕ⋂B' 
				|| this.equation == 'B⋂Ω' || this.equation == 'Ω⋂B'){
					this.equation1 = 'B'
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/onlyB.png")
					
				}else if (this.equation == 'C⋃C' || this.equation == 'C⋂C' || this.equation == 'C⋂ϕ'
				|| this.equation == 'C⋃ϕ' || this.equation == 'ϕ⋃C' || this.equation == 'ϕ⋂C' 
				|| this.equation == 'C⋂Ω' || this.equation == 'Ω⋂C'){
					this.equation1 = 'C'
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/onlyC.png")
					
				}else if (this.equation == 'A̅⋃A̅' || this.equation == 'A̅⋂A̅' || this.equation == 'A̅⋂ϕ'
				|| this.equation == 'A̅⋃ϕ' || this.equation == 'ϕ⋃A̅' || this.equation == 'ϕ⋂A̅' 
				|| this.equation == 'A̅⋂Ω' || this.equation == 'Ω⋂A̅'){
					this.equation1 = 'A̅'
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/withoutA.png")
					
				}else if (this.equation == 'B̅⋃B̅' || this.equation == 'B̅⋂B̅' || this.equation == 'B̅⋂ϕ'
				|| this.equation == 'B̅⋃ϕ' || this.equation == 'ϕ⋃B̅' || this.equation == 'ϕ⋂B̅' 
				|| this.equation == 'B̅⋂Ω' || this.equation == 'Ω⋂B̅'){
					this.equation1 = 'B̅'
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/withoutB.png")
					
				}else if (this.equation == 'C̅⋃C̅' || this.equation == 'C̅⋂C̅' || this.equation == 'C̅⋂ϕ'
				|| this.equation == 'C̅⋃ϕ' || this.equation == 'ϕ⋃C̅' || this.equation == 'ϕ⋂C̅' 
				|| this.equation == 'C̅⋂Ω' || this.equation == 'Ω⋂C̅'){
					this.equation1 = 'C̅'
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/withoutC.png")
					
				}else if (this.equation == 'Ω⋃Ω' || this.equation == 'Ω⋂Ω' 
				|| this.equation == 'Ω⋂ϕ' || this.equation == 'Ω⋃ϕ' || this.equation == 'ϕ⋃Ω' || this.equation == 'ϕ⋂Ω' 
				|| this.equation == 'A⋃Ω' || this.equation == 'Ω⋃A'
				|| this.equation == 'B⋃Ω' || this.equation == 'Ω⋃B'
				|| this.equation == 'C⋃Ω' || this.equation == 'Ω⋃C'
				|| this.equation == 'A⋂B⋃Ω' || this.equation == 'B⋂A⋃Ω'
				|| this.equation == 'A⋂C⋃Ω' || this.equation == 'C⋂A⋃Ω'
				|| this.equation == 'C⋂B⋃Ω' || this.equation == 'B⋂C⋃Ω'
				|| this.equation == 'A̅⋃Ω' || this.equation == 'Ω⋃A̅'
				|| this.equation == 'B̅⋃Ω' || this.equation == 'Ω⋃B̅'
				|| this.equation == 'C̅⋃Ω' || this.equation == 'Ω⋃C̅'){
					this.equation1 = 'Ω'
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/quanji.png")
					
				}else if (this.equation == 'ϕ⋃ϕ' || this.equation == 'ϕ⋂ϕ'){
					this.equation1 = 'ϕ'
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/origin.png")
					
				}else if( this.equation == 'A⋂B' || this.equation == 'A⋂ϕ⋂B' || this.equation == 'A⋂B⋂ϕ'|| this.equation == 'ϕ⋂A⋂B'
				|| this.equation == 'B⋂A' || this.equation == 'B⋂ϕ⋂A' || this.equation == 'B⋂A⋂ϕ'|| this.equation == 'ϕ⋂B⋂A'){
					this.equation1 = 'AB'		//一个花瓣AB
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/jiaojiAB.png")
					
				}else if (this.equation == 'A⋂C' || this.equation == 'A⋂ϕ⋂C' || this.equation == 'A⋂C⋂ϕ'|| this.equation == 'ϕ⋂A⋂C'
				|| this.equation == 'C⋂A' || this.equation == 'C⋂ϕ⋂A' || this.equation == 'C⋂A⋂ϕ'|| this.equation == 'ϕ⋂C⋂A'){
					this.equation1 = 'AC'		//一个花瓣AC
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/jiaojiAC.png")
					
				}else if (this.equation == 'C⋂B' || this.equation == 'C⋂ϕ⋂B' || this.equation == 'C⋂B⋂ϕ'|| this.equation == 'ϕ⋂C⋂B'
				|| this.equation == 'B⋂C' || this.equation == 'B⋂ϕ⋂C' || this.equation == 'B⋂C⋂ϕ'|| this.equation == 'ϕ⋂B⋂C'){
					this.equation1 = 'BC'		//一个花瓣BC
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/jiaojiBC.png")
					
				}else if (this.equation == 'A⋃B' || this.equation == 'A⋃ϕ⋃B' || this.equation == 'A⋃B⋃ϕ'|| this.equation == 'ϕ⋃A⋃B'
				|| this.equation == 'B⋃A' || this.equation == 'B⋃ϕ⋃A' || this.equation == 'B⋃A⋃ϕ'|| this.equation == 'ϕ⋃B⋃A'
				|| this.equation == 'A⋃B⋂C' || this.equation == 'B⋃A⋂C'		/*这一行的两个没考虑空集*/){
					this.equation1 = 'A⋃B'		//两个圆AB
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/ABtwoyuan.png")
					
				}else if (this.equation == 'A⋃C' || this.equation == 'A⋃ϕ⋃C' || this.equation == 'A⋃C⋃ϕ'|| this.equation == 'ϕ⋃A⋃C'
				|| this.equation == 'C⋃A' || this.equation == 'C⋃ϕ⋃A' || this.equation == 'C⋃A⋃ϕ'|| this.equation == 'ϕ⋃C⋃A'
				|| this.equation == 'A⋃C⋂B' || this.equation == 'C⋃A⋂B'		/*这一行的两个没考虑空集*/){
					this.equation1 = 'A⋃C'		//两个圆AC
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/ACtwoyuan.png")
					
				}else if (this.equation == 'C⋃B' || this.equation == 'C⋃ϕ⋃B' || this.equation == 'C⋃B⋃ϕ'|| this.equation == 'ϕ⋃C⋃B'
				|| this.equation == 'B⋃C' || this.equation == 'B⋃ϕ⋃C' || this.equation == 'B⋃C⋃ϕ'|| this.equation == 'ϕ⋃B⋃C'
				|| this.equation == 'B⋃C⋂A' || this.equation == 'C⋃B⋂A'		/*这一行的两个没考虑空集*/){
					this.equation1 = 'B⋃C'		//两个圆BC
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/BCtwoyuan.png")
					
				}else if (this.equation == 'A̅⋂B̅' || this.equation == 'A̅⋂ϕ⋂B̅' || this.equation == 'A̅⋂B̅⋂ϕ'|| this.equation == 'ϕ⋂A̅⋂B̅'
				|| this.equation == 'B̅⋂A̅' || this.equation == 'B̅⋂ϕ⋂A̅' || this.equation == 'B̅⋂A̅⋂ϕ'|| this.equation == 'ϕ⋂B̅⋂A̅'){
					this.equation1 = 'A̅B̅'		//挖掉AB两圆
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/withoutABtwoyuan.png")
					
				}else if (this.equation == 'A̅⋂C̅' || this.equation == 'A̅⋂ϕ⋂C̅' || this.equation == 'A̅⋂C̅⋂ϕ'|| this.equation == 'ϕ⋂A̅⋂C̅'
				|| this.equation == 'C̅⋂A̅' || this.equation == 'C̅⋂ϕ⋂A̅' || this.equation == 'C̅⋂A̅⋂ϕ'|| this.equation == 'ϕ⋂C̅⋂A̅'){
					this.equation1 = 'A̅C̅'		//挖掉AC两圆
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/withoutACtwoyuan.png")
					
				}else if (this.equation == 'B̅⋂C̅' || this.equation == 'B̅⋂ϕ⋂C̅' || this.equation == 'B̅⋂C̅⋂ϕ'|| this.equation == 'ϕ⋂B̅⋂C̅'
				|| this.equation == 'C̅⋂B̅' || this.equation == 'C̅⋂ϕ⋂B̅' || this.equation == 'C̅⋂B̅⋂ϕ'|| this.equation == 'ϕ⋂C̅⋂B̅'){
					this.equation1 = 'B̅C̅'		//挖掉BC两圆
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/withoutBCtwoyuan.png")
					
				}else if (this.equation == 'A̅⋃B̅⋃C̅' || this.equation == 'A̅⋃B̅⋃ϕ⋃C̅' || this.equation == 'A̅⋃B̅⋃C̅⋃ϕ' 
				|| this.equation == 'ϕ⋃A̅⋃B̅⋃C̅' || this.equation == 'A̅⋃ϕ⋃B̅⋃C̅'
				
				|| this.equation == 'A̅⋃C̅⋃B̅' || this.equation == 'A̅⋃C̅⋃ϕ⋃B̅' || this.equation == 'A̅⋃C̅⋃B̅⋃ϕ'
				|| this.equation == 'A̅⋃ϕ⋃C̅⋃B̅'|| this.equation == 'ϕ⋃A̅⋃C̅⋃B̅'
				
				|| this.equation == 'B̅⋃A̅⋃C̅' || this.equation == 'B̅⋃A̅⋃ϕ⋃C̅' || this.equation == 'B̅⋃A̅⋃C̅⋃ϕ'
				|| this.equation == 'ϕ⋃B̅⋃A̅⋃C̅' || this.equation == 'B̅⋃ϕ⋃A̅⋃C̅'
				
				|| this.equation == 'B̅⋃C̅⋃A̅' || this.equation == 'B̅⋃C̅⋃ϕ⋃A̅' || this.equation == 'B̅⋃C̅⋃A̅⋃ϕ'
				|| this.equation == 'ϕ⋃B̅⋃C̅⋃A̅' || this.equation == 'B̅⋃ϕ⋃C̅⋃A̅'
				
				|| this.equation == 'C̅⋃A̅⋃B̅' || this.equation == 'C̅⋃A̅⋃ϕ⋃B̅' || this.equation == 'C̅⋃A̅⋃B̅⋃ϕ'
				|| this.equation == 'C̅⋃ϕ⋃A̅⋃B̅'|| this.equation == 'ϕ⋃C̅⋃A̅⋃B̅'
				
				|| this.equation == 'C̅⋃B̅⋃A̅' || this.equation == 'C̅⋃B̅⋃ϕ⋃A̅' || this.equation == 'C̅⋃B̅⋃A̅⋃ϕ'
				|| this.equation == 'C̅⋃ϕ⋃B̅⋃A̅'|| this.equation == 'ϕ⋃C̅⋃B̅⋃A̅'){
					this.equation1 = 'A̅⋃C̅⋃B̅'		//挖掉ABC交集中心一点
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/withoutABCjiaoji.png")
				
				}else if (this.equation == 'A̅⋃B̅' || this.equation == 'A̅⋃ϕ⋃B̅' || this.equation == 'A̅⋃B̅⋃ϕ'|| this.equation == 'ϕ⋃A̅⋃B̅'
				|| this.equation == 'B̅⋃A̅' || this.equation == 'B̅⋃ϕ⋃A̅' || this.equation == 'B̅⋃A̅⋃ϕ'|| this.equation == 'ϕ⋃B̅⋃A̅'){
					this.equation1 = 'A̅⋃B̅'		//挖掉AB交集
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/withoutABjiaoji.png")
				
				}else if (this.equation == 'A̅⋃C̅' || this.equation == 'A̅⋃ϕ⋃C̅' || this.equation == 'A̅⋃C̅⋃ϕ'|| this.equation == 'ϕ⋃A̅⋃C̅'
				|| this.equation == 'C̅⋃A̅' || this.equation == 'C̅⋃ϕ⋃A̅' || this.equation == 'C̅⋃A̅⋃ϕ'|| this.equation == 'ϕ⋃C̅⋃A̅'){
					this.equation1 = 'A̅⋃C̅'		//挖掉AC交集
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/withoutACjiaoji.png")
					
				}else if (this.equation == 'B̅⋃C̅' || this.equation == 'B̅⋃ϕ⋃C̅' || this.equation == 'B̅⋃C̅⋃ϕ'|| this.equation == 'ϕ⋃B̅⋃C̅'
				|| this.equation == 'C̅⋃B̅' || this.equation == 'C̅⋃ϕ⋃B̅' || this.equation == 'C̅⋃B̅⋃ϕ'|| this.equation == 'ϕ⋃C̅⋃B̅'){
					this.equation1 = 'B̅⋃C̅'		//挖掉BC交集
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/withoutBCjiaoji.png")
				
				}else if (
				//三个，暂时都不考虑加入空集情况
				this.equation == 'A⋂B⋂C' || this.equation == 'A⋂C⋂B' || this.equation == 'B⋂C⋂A' 
				|| this.equation == 'B⋂A⋂C' || this.equation == 'C⋂A⋂B' || this.equation == 'C⋂B⋂A'){
					this.equation1 = 'A⋂B⋂C'	//中心的一点
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/ABCthreejiaoji.png")
					
				}else if (this.equation == 'A⋃B⋃C' || this.equation == 'A⋃C⋃B' || this.equation == 'B⋃C⋃A'
				|| this.equation == 'B⋃A⋃C' || this.equation == 'C⋃A⋃B' || this.equation == 'C⋃B⋃A'){
					this.equation1 = 'A⋃B⋃C'	//三个圆
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/ABCthreeyuan.png")
					
				}else if (this.equation == 'A̅⋂B̅⋂C̅' || this.equation == 'A̅⋂B̅⋂ϕ⋂C̅' || this.equation == 'A̅⋂B̅⋂C̅⋂ϕ'
				|| this.equation == 'ϕ⋂A̅⋂B̅⋂C̅' || this.equation == 'A̅⋂ϕ⋂B̅⋂C̅'
				
				|| this.equation == 'A̅⋂C̅⋂B̅' || this.equation == 'A̅⋂C̅⋂ϕ⋂B̅' || this.equation == 'A̅⋂C̅⋂B̅⋂ϕ'
				|| this.equation == 'A̅⋂ϕ⋂C̅⋂B̅'|| this.equation == 'ϕ⋂A̅⋂C̅⋂B̅'
				
				|| this.equation == 'B̅⋂A̅⋂C̅' || this.equation == 'B̅⋂A̅⋂ϕ⋂C̅' || this.equation == 'B̅⋂A̅⋂C̅⋂ϕ'
				|| this.equation == 'ϕ⋂B̅⋂A̅⋂C̅' || this.equation == 'B̅⋂ϕ⋂A̅⋂C̅'
				
				|| this.equation == 'B̅⋂C̅⋂A̅' || this.equation == 'B̅⋂C̅⋂ϕ⋂A̅' || this.equation == 'B̅⋂C̅⋂A̅⋂ϕ'
				|| this.equation == 'ϕ⋂B̅⋂C̅⋂A̅' || this.equation == 'B̅⋂ϕ⋂C̅⋂A̅'
				
				|| this.equation == 'C̅⋂A̅⋂B̅' || this.equation == 'C̅⋂A̅⋂ϕ⋂B̅' || this.equation == 'C̅⋂A̅⋂B̅⋂ϕ'
				|| this.equation == 'C̅⋂ϕ⋂A̅⋂B̅'|| this.equation == 'ϕ⋂C̅⋂A̅⋂B̅'
				
				|| this.equation == 'C̅⋂B̅⋂A̅' || this.equation == 'C̅⋂B̅⋂ϕ⋂A̅' || this.equation == 'C̅⋂B̅⋂A̅⋂ϕ'
				|| this.equation == 'C̅⋂ϕ⋂B̅⋂A̅'|| this.equation == 'ϕ⋂C̅⋂B̅⋂A̅'){
					this.equation1 = 'A̅⋂C̅⋂B̅'		//挖掉三个圆
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/withoutthreeyuan.png")
					
				}else if (this.equation == 'A⋂B⋃C' || this.equation == 'B⋂A⋃C'){
					this.equation1 = 'A⋂B⋃C'	//头发向上的人体
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/CjiaABjiaoji.png")
					
				}else if (this.equation == 'A⋂C⋃B' || this.equation == 'C⋂A⋃B'){
					this.equation1 = 'A⋂C⋃B'	//头发向左下的人体
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/BjiaACjiaoji.png")
					
				}else if (this.equation == 'B⋂C⋃A' || this.equation == 'C⋂B⋃A'){
					this.equation1 = 'B⋂C⋃A'	//头发向右上的人体
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/AjiaBCjiaoji.png")
					
				}else{
					this.equation1 = '无效输入'
					this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/origin.png")
				}
				
			   this.isOperatorAdded = false
			   this.isNumberAdded = false
			 },
			
			 // When pressed 'AC'
			 clear() {
			   this.equation = '0'
			   this.equation1 = ''
			   this.isNumberAdded = false
			   this.isStarted = false
			   this.isOperatorAdded = false
			   this.jisuanjieguotupian = require("@/"+"/static/jisuanqitupian/origin.png")
			 }
		}
	}
</script>

<style>
	body {
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  min-height: 100vh;
	  background-color: #eee;
	}
	
	.app{
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	.calculator {
		border: 3px solid #353535;
	  --button-width: 80px;
	  --button-height: 80px;
	  
	  display: grid;
	  grid-template-areas: "result result result result"
	    "result1 result1 result1 result1"
	    "A B C Jiao"
	    "A̅ B̅ C̅ Bing"
	    "Kongji Quanji clear equal";
	  grid-template-columns: repeat(4, var(--button-width));
	  grid-template-rows: repeat(5, var(--button-height));
	  
	  /* box-shadow: -8px -8px 16px -10px rgba(255, 255, 255, 1), 8px 8px 16px -10px rgba(0, 0, 0, .15); */
	  /* padding: 24px; */
	  border-radius: 20px;
	  margin: 0 auto;
	}
	
	.calculator button {
	  margin: 8px;
	  padding: 0;
	  border: 0;
	  display: block;
	  outline: none;
	  /* 下面的是设置圆角的 */
	  /* border-radius: calc(var(--button-height) / 2); */
	  font-size: 24px;
	  font-family: Helvetica;
	  font-weight: normal;
	  color: #999;
	  background: linear-gradient(135deg, rgba(230, 230, 230, 1) 0%, rgba(246, 246, 246, 1) 100%);
	  box-shadow: -4px -4px 10px -8px rgba(255, 255, 255, 1), 4px 4px 10px -8px rgba(0, 0, 0, .3);
	}
	
	/* 这里的inset是不是没起作用 */
	.calculator button:active {
	  box-shadow: -4px -4px 10px -8px rgba(255, 255, 255, 1) inset, 4px 4px 10px -8px rgba(0, 0, 0, .3) inset;
	}
	
	.result {
	  text-align: right;
	  line-height: var(--button-height);
	  font-size: 48px;
	  font-family: Helvetica;
	  padding: 0 20px;
	  color: #353535;
	}
	
	.result1 {
	  text-align: right;
	  line-height: var(--button-height);
	  font-size: 48px;
	  font-family: Helvetica;
	  padding: 0 20px;
	  color: #353535;
	}
	
	.tupian{
		margin: 0 auto;
		width: 350px;
		height: 200px;
		display: flex;
				justify-content: center;
				align-items: center;
	}
	image {
		margin: 0 auto;
		width: 325px;
		height: 200px;
	}
</style>
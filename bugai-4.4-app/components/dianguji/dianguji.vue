<template>
  <view class="container">
<!-- 	  <view>
		  点估计是一种利用样本数据推断总体参数的方法。在点估计中，我们使用样本统计量（如样本均值、样本方差）来估计总体参数（如总体均值、总体方差）。点估计的目标是寻找一个点估计量，使其无偏或渐进无偏，并且具有最小的方差，从而提高估计的精度。
	  </view> -->
    <view class="form">
      <view class="form-item">
        <text class="form-label">样本数据：</text>
        <textarea v-model="sampleData" placeholder="输入样本数据，每个样本之间用逗号或空格隔开"></textarea>
      </view>
      <view class="form-item">
        <text class="form-label">总体参数：</text>
        <input v-model="popParameter" type="number" placeholder="输入要估计的总体参数">
      </view>
      <view class="form-item">
        <text class="form-label">置信水平：</text>
        <select v-model="confidenceLevel">
          <option value="0.95">95%</option>
          <option value="0.99">99%</option>
        </select>
      </view>
      <view class="form-item">
        <button class="calc-btn" @click="calculate">计算</button>
      </view>
    </view>
    <!-- <view class="result" v-if="showResult">
      <text class="result-label">点估计量：</text>
      <text class="result-value">{{ pointEstimate }}</text>
      <text class="result-label">估计误差：</text>
      <text class="result-value">{{ stdError }}</text>
      <text class="result-label">置信区间：</text>
      <text class="result-value">{{ confidenceInterval }}</text>
    </view>
	 -->
	<view class="result" v-if="showResult">
	 <view>点估计量：{{ pointEstimate }}</view>
	  <view>估计误差：{{ stdError }}</view>
	  <view>置信区间：{{ confidenceInterval }}</view>
	</view>
  </view>
</template>

<script>
export default {
	name: 'dianguji',
  data() {
    return {
      sampleData: '',
      popParameter: null,
      confidenceLevel: 0.95,
      pointEstimate: null,
      stdError: null,
      confidenceInterval: null,
      showResult: false
    }
  },
  methods: {
    calculate() {
      // 将输入的样本数据转换为数组
      const sample = this.sampleData.trim().split(/[\s,]+/).map(Number)
      
      // 计算样本均值和样本标准差
      const sampleMean = sample.reduce((a, b) => a + b, 0) / sample.length
      const sampleStdDev = Math.sqrt(sample.reduce((a, b) => a + (b - sampleMean) ** 2, 0) / (sample.length - 1))
      
      // 计算点估计量
      this.pointEstimate = sampleMean
      
      // 计算估计误差
      this.stdError = sampleStdDev / Math.sqrt(sample.length)
      
      // 计算置信区间
      const zScore = this.confidenceLevel === 0.95 ? 1.96 : 2.58 // 根据置信水平确定z值
      const lowerBound = sampleMean - zScore * (sampleStdDev / Math.sqrt(sample.length))
      const upperBound = sampleMean + zScore * (sampleStdDev / Math.sqrt(sample.length))
      this.confidenceInterval = `[${lowerBound.toFixed(2)}, ${upperBound.toFixed(2)}]`
      
      // 显示结果
      this.showResult = true
    }
  }
}
</script>
<style>
  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100%;
  }

  .form {
    display: flex;
    flex-direction: column;
    gap: 10px;
    margin-bottom: 20px;
  }

  .form-item {
    display: flex;
    align-items: center;
  }

  .form-label {
    margin-right: 10px;
  }

  textarea, input, select {
    flex: 1;
    height: 30px;
    font-size: 13px;
    padding: 5px;
    border-radius: 5px;
    border: 1px solid #ccc;
    outline: none;
  }

  .calc-btn {
    height: 30px;
    font-size: 16px;
    padding: 0 10px;
    border-radius: 5px;
    border: none;
    background-color: #007aff;
    color: #fff;
    cursor: pointer;
    outline: none;
  }

  .result {
    display: flex;
    flex-direction: column;
    gap: 10px;
    text-align: center;
  }

  .result-label {
    font-size: 18px;
    font-weight: bold;
  }

  .result-value {
    font-size: 16px;
  }
</style>
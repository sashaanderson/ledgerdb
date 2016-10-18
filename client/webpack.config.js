var webpack = require('webpack');

module.exports = {
  entry: './index.js',
  output: {
    path: '../server/src/main/resources/assets/',
    filename: 'bundle.js'
  },
  module: {
    loaders: [
      {
        test: /\.jsx?$/,
        loader: 'babel-loader',
        exclude: /node_modules/,
        query: {
          presets: ['es2015', 'react']
        }
      }
    ]
  }
};
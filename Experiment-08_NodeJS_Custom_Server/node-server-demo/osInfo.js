const os = require('os');

console.log('OS Info:');
console.log('Platform:', os.platform());
console.log('CPU Architecture:', os.arch());
console.log('Total Memory:', os.totalmem());
console.log('Free Memory:', os.freemem());
console.log('Uptime (seconds):', os.uptime());
console.log('User Info:', os.userInfo());

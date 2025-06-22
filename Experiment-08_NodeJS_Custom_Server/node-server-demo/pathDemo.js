const path = require('path');

const filePath = '/users/prakash/docs/file.txt';

console.log('Directory:', path.dirname(filePath));
console.log('Extension:', path.extname(filePath));
console.log('Base name:', path.basename(filePath));
console.log('Join paths:', path.join('/foo', 'bar', 'baz/asdf', 'quux', '..'));

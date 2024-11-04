/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function(rows, cols) {
    if (rows * cols !== this.length) {
        return [];
    }
    const result = Array.from({ length: rows }, () => Array(cols).fill(0));

    let col = 0, row = 0;
    let countTotal = 0;
    let isDownDirection = true;
    while (countTotal < this.length) {
        result[row][col] = this[countTotal];
        if (isDownDirection) {
            row++;
        } else {
            row--;
        }
        if (row >= rows) {
            col++;
            row--;
            isDownDirection = false;
        } else if (row < 0) {
            col++;
            row++;
            isDownDirection = true;
        }
        countTotal++;
    }

    return result;
}

/**
 * const arr = [1,2,3,4];
 * arr.snail(1,4); // [[1,2,3,4]]
 */
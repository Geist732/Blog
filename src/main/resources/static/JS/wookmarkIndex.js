$(document).ready(new function() {
    // Call the layout function.
    $('#tiles li').wookmark({
        autoResize: true, // This will auto-update the layout when the browser window is resized.
        container: $('#tiles'), // Optional, used for some extra CSS styling
        offset: 2, // Optional, the distance between grid items
        itemWidth: 210 // Optional, the width of a grid item
    });
});
// Function to fetch the public IP and send it to your backend
async function logPublicIP() {
    try {
        // Fetch the public IP using an external API
        const ipResponse = await fetch('https://api.ipify.org?format=json');
        const ipData = await ipResponse.json();
        const publicIP = ipData.ip;

        // Send the public IP to your backend server to log it
        const logResponse = await fetch('https://YOUR_BACKEND_API_URL/log-ip', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ ip: publicIP }),
        });

        if (logResponse.ok) {
            console.log('IP logged successfully!');
        } else {
            console.error('Failed to log IP');
        }
    } catch (error) {
        console.error('Error fetching or logging IP:', error);
    }
}

// Call the function to log the IP
logPublicIP();

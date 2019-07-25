import React from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogContentText from "@material-ui/core/DialogContentText";
import DialogTitle from "@material-ui/core/DialogTitle";

export default function AddPassenger(props) {
  const [name, setName] = React.useState(props.name);

  const [identifier, setIdentifier] = React.useState(props.identifier);

  const [flightId, setFlightId] = React.useState(props.flightId);

  return (
    <div>
      <Dialog
        open={props.open}
        onClose={props.handleClose}
        aria-labelledby="form-dialog-title"
      >
        <DialogTitle id="form-dialog-title">Add passenger</DialogTitle>
        <DialogContent>
          <DialogContentText>
            Please fill this form with your personal informations in order to
            complete the reservation
          </DialogContentText>
          {!props.reservations ? (
            <TextField
              autoFocus
              margin="dense"
              id="name"
              label="Name"
              type="passengerName"
              fullWidth
              onChange={e => setName(e.target.value)}
            />
          ) : null}
          <TextField
            autoFocus
            margin="dense"
            id="identifier"
            onChange={e => setIdentifier(e.target.value)}
            label="Unique identifier (ex: CNP, SSN)"
            type="passengerIdentifier"
            fullWidth
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={props.handleClose} color="primary">
            Cancel
          </Button>
          <Button
            onClick={() => {
              props.onComplete({
                flightId,
                uniqueIdentifier: identifier,
                name: name
              });
            }}
            color="primary"
          >
            Complete
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
